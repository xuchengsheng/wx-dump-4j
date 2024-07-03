package com.xcs.wx.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.HexUtil;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.xcs.wx.config.WeChatOffsetProperties;
import com.xcs.wx.domain.vo.WeChatConfigVO;
import com.xcs.wx.exception.BizException;
import com.xcs.wx.service.WeChatService;
import com.xcs.wx.util.Pbkdf2HmacUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 微信服务实现类
 *
 * @author xcs
 * @date 2023年12月25日 09时37分
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class WeChatServiceImpl implements WeChatService {

    /**
     * 微信进程
     */
    private static final String EXE_NAME = "WeChat.exe";

    /**
     * 微信程序dll文件
     */
    private static final String MODULE_NAME = "WeChatWin.dll";

    /**
     * 文档目录
     */
    private static final String MY_DOCUMENT = "MyDocument:";

    /**
     * 注册表中 WeChat 的路径
     */
    private static final String WECHAT_REG_PATH = "Software\\Tencent\\WeChat";

    /**
     * 注册表键值名称
     */
    private static final String FILE_SAVE_PATH = "FileSavePath";

    /**
     * WeChat 文件夹名称
     */
    private static final String WECHAT_FILES_DIR = "\\WeChat Files";

    /**
     * WeChat 配置文件的路径
     */
    private static final String CONFIG_FILE_PATH = "\\AppData\\Roaming\\Tencent\\WeChat\\All Users\\config\\3ebffe94.ini";

    /**
     * 微信内存地址偏移量配置
     */
    private final WeChatOffsetProperties weChatOffsetConfig;

    @Override
    public List<WeChatConfigVO> readWeChatConfig() {
        // 获取微信进程Id
        List<Integer> pidList = wechatPid();
        // 微信未登录
        if (pidList.isEmpty()) {
            throw new BizException(-1, "检测到微信尚未启动，请先打开微信以继续进行操作。");
        }
        List<WeChatConfigVO> weChatConfigVOList = new ArrayList<>();
        // 遍历微信Id列表
        for (Integer pid : pidList) {
            // 获取版本号
            String version = getVersion(pid);
            // 支持最小的版本号
            String supportMinVersion = weChatOffsetConfig.getVersion().keySet().stream().findFirst().orElse("0.0.0.0");
            // 校验版本号
            if (compareVersions(supportMinVersion, version)) {
                throw new BizException(-1, "当前微信版本不支持,请升级微信最新版本,当前微信版本号:" + version);
            }
            // 读取微信版本对应的偏移量
            WeChatOffsetProperties.VersionConfig versionConfig = getVersionConfig(version);
            // 未读取到偏移量
            if (versionConfig == null) {
                throw new BizException(-1, "未读取到偏移量配置,请从Github获取最新代码,当前微信版本号:" + version);
            }
            // 获取微信的基址
            long baseAddress = baseAddress(pid);
            // 获取微信昵称
            String nickname = getInfo(pid, (baseAddress + versionConfig.getNickname()));
            // 获取微信账号
            String account = getInfo(pid, (baseAddress + versionConfig.getAccount()));
            // 获取微信手机号
            String mobile = getInfo(pid, (baseAddress + versionConfig.getMobile()));
            // 获取微信文件目录
            String basePath = getBasePath();
            // 获取微信Id
            String wxId = getWxId(pid);
            // 返回配置信息
            weChatConfigVOList.add(new WeChatConfigVO(pid, baseAddress, version, nickname, account, mobile, basePath, wxId));
        }
        return weChatConfigVOList;
    }

    /**
     * 根据版本号查找匹配的内容
     *
     * @param version 要查找的版本号
     * @return 返回匹配的版本内容，如果未找到则返回 null
     */
    public WeChatOffsetProperties.VersionConfig getVersionConfig(String version) {
        Map<String, WeChatOffsetProperties.VersionConfig> versionConfigMap = weChatOffsetConfig.getVersion();
        // 尝试精准匹配
        if (versionConfigMap.containsKey(version)) {
            return versionConfigMap.get(version);
        }

        String matchingVersion = null;

        // 遍历版本数据的所有版本号，找到匹配前三位相同的最新版本
        for (String availableVersion : versionConfigMap.keySet()) {
            if (isMatchingPrefix(version, availableVersion) && (matchingVersion == null || availableVersion.compareTo(matchingVersion) > 0)) {
                matchingVersion = availableVersion;
            }
        }

        // 返回匹配的版本内容，如果都没有匹配到则返回 null
        return (matchingVersion != null) ? versionConfigMap.get(matchingVersion) : null;
    }

    /**
     * 判断两个版本号前三位是否相同
     *
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 如果前三位相同返回 true，否则返回 false
     */
    private boolean isMatchingPrefix(String version1, String version2) {
        return version1.substring(0, 5).equals(version2.substring(0, 5));
    }

    /**
     * 获取当前运行的微信进程的进程 ID。
     *
     * @return 微信进程的进程 ID。如果未找到，返回 0。
     */
    @Override
    public List<Integer> wechatPid() {
        List<Integer> pidList = new ArrayList<>();
        // 实例化Kernel32库接口
        Kernel32 kernel32 = Kernel32.INSTANCE;

        // 创建系统快照，用来枚举所有进程
        WinNT.HANDLE hSnapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
        // 初始化进程入口结构体
        Tlhelp32.PROCESSENTRY32.ByReference pe32 = new Tlhelp32.PROCESSENTRY32.ByReference();

        // 遍历所有进程
        if (kernel32.Process32First(hSnapshot, pe32)) {
            do {
                // 获取进程名
                String exeName = Native.toString(pe32.szExeFile);
                // 检查进程名是否为目标进程名
                if (exeName.equalsIgnoreCase(EXE_NAME)) {
                    // 返回找到的进程ID
                    pidList.add(pe32.th32ProcessID.intValue());
                }
                // 继续遍历下一个进程
            } while (kernel32.Process32Next(hSnapshot, pe32));
        }
        // 关闭快照句柄
        kernel32.CloseHandle(hSnapshot);
        // 如果没有找到进程，返回0
        return pidList;
    }

    /**
     * 根据提供的进程 ID 找到相应进程的模块基地址。
     *
     * @param pid 目标进程的 ID。
     * @return 进程的模块基地址，如果找不到则返回 0。
     */
    @Override
    public long baseAddress(int pid) {
        Kernel32 kernel32 = Kernel32.INSTANCE;

        // 创建模块快照
        WinNT.HANDLE hModuleSnapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPMODULE, new WinDef.DWORD(pid));

        // 确保快照创建成功
        if (!WinNT.INVALID_HANDLE_VALUE.equals(hModuleSnapshot)) {
            // 初始化 MODULEENTRY32W 结构体的引用
            Tlhelp32.MODULEENTRY32W.ByReference me32 = new Tlhelp32.MODULEENTRY32W.ByReference();

            // 遍历所有模块
            if (kernel32.Module32FirstW(hModuleSnapshot, me32)) {
                do {
                    // 从模块入口结构中读取模块名
                    String moduleName = Native.toString(me32.szModule);
                    // 检查是否为微信 DLL
                    if (MODULE_NAME.equalsIgnoreCase(moduleName)) {
                        // 返回微信 DLL 的基地址
                        kernel32.CloseHandle(hModuleSnapshot);
                        return Pointer.nativeValue(me32.modBaseAddr);
                    }
                } while (kernel32.Module32NextW(hModuleSnapshot, me32));
            }
            // 关闭快照句柄
            kernel32.CloseHandle(hModuleSnapshot);
        }
        // 如果未找到微信 DLL，返回 0
        return 0;
    }

    /**
     * 从指定进程的指定内存地址读取信息。
     *
     * @param pid     目标进程的 ID。
     * @param address 要读取的内存地址。
     * @return 读取到的数据，如果失败则返回 null。
     */
    @Override
    public String getInfo(int pid, long address) {
        Kernel32 kernel32 = Kernel32.INSTANCE;
        // 打开目标进程
        WinNT.HANDLE process = kernel32.OpenProcess(WinNT.PROCESS_VM_READ, false, pid);

        // 分配内存作为缓冲区读取数据
        int bufferSize = 64;
        Memory buffer = new Memory(bufferSize);
        IntByReference read = new IntByReference();

        // 从指定地址读取内存
        boolean success = kernel32.ReadProcessMemory(process, new Pointer(address), buffer, bufferSize, read);

        if (success) {
            // 将读取的字节转换为字符串
            byte[] dataBytes = buffer.getByteArray(0, read.getValue());
            String data = new String(dataBytes, 0, read.getValue());

            // 查找第一个空字符（字符串结束标志）
            int nullPos = data.indexOf('\0');
            if (nullPos != -1) {
                // 截取到第一个空字符为止的字符串
                data = data.substring(0, nullPos);
            }

            // 返回读取的字符串，如果为空则返回 null
            kernel32.CloseHandle(process);
            return data.isEmpty() ? null : data;
        }

        // 关闭进程句柄
        kernel32.CloseHandle(process);

        return null;
    }

    /**
     * 获取指定进程和数据库路径下的密钥
     *
     * @param pid    目标进程的进程ID
     * @param dbPath 数据库路径
     * @return 返回找到的密钥，如果未找到则返回null
     */
    @Override
    public String getKey(int pid, String dbPath) {
        // 打开目标进程
        WinNT.HANDLE process = Kernel32.INSTANCE.OpenProcess(0x1F0FFF, false, pid);

        // 定义不同平台对应的字节数组
        byte[] iphoneByteArray = "iphone\0".getBytes();
        byte[] androidByteArray = "android\0".getBytes();
        byte[] ipadByteArray = "ipad\0".getBytes();

        // 用于存储不同平台的模块扫描结果
        List<Pointer> typeAddress = new ArrayList<>();
        List<Pointer> typeAddress1 = patternScanModule(process, iphoneByteArray);
        List<Pointer> typeAddress2 = patternScanModule(process, androidByteArray);
        List<Pointer> typeAddress3 = patternScanModule(process, ipadByteArray);

        // 优先选择长度至少为2的模块地址列表
        if (typeAddress1.size() >= 2) {
            typeAddress = typeAddress1;
        } else if (typeAddress2.size() >= 2) {
            typeAddress = typeAddress2;
        } else if (typeAddress3.size() >= 2) {
            typeAddress = typeAddress3;
        } else if (!typeAddress1.isEmpty()) {
            typeAddress = typeAddress1;
        } else if (!typeAddress2.isEmpty()) {
            typeAddress = typeAddress2;
        } else if (!typeAddress3.isEmpty()) {
            typeAddress = typeAddress3;
        }

        // 拼接MicroMsg数据库路径
        String microMsg = dbPath + "\\Msg\\MicroMsg.db";

        // 获取倒序迭代器
        ListIterator<Pointer> pointerListIterator = typeAddress.listIterator(typeAddress.size());

        // 倒序遍历模块地址列表
        while (pointerListIterator.hasPrevious()) {
            Pointer addressPointer = pointerListIterator.previous();
            long address = Pointer.nativeValue(addressPointer);

            // 在地址范围内以步长8递减遍历，读取密钥
            for (long i = address; i >= (address - 2000); i -= 8) {
                // 读取key
                String key = readKey(process, i);

                // 如果密钥不为空且验证通过，则返回密钥
                if (key != null && verifyKey(key, microMsg)) {
                    return key;
                }
            }
        }
        // 未找到匹配的密钥，返回null
        return null;
    }

    /**
     * 获取秘钥
     *
     * @param address 要读取的内存地址
     * @return 读取到的秘钥，如果失败则返回 null。
     */
    private String readKey(WinNT.HANDLE process, long address) {
        Kernel32 kernel32 = Kernel32.INSTANCE;

        // 准备缓冲区用于读取内存
        Memory buffer = new Memory(8);
        IntByReference bytesRead = new IntByReference();
        // 读取目标进程的内存地址
        if (!kernel32.ReadProcessMemory(process, new Pointer(address), buffer, (int) buffer.size(), bytesRead)) {
            return null;
        }

        // 将缓冲区中的字节转换为长整型值
        ByteBuffer bufferWrap = ByteBuffer.wrap(buffer.getByteArray(0, 8)).order(ByteOrder.LITTLE_ENDIAN);
        long keyAddress = bufferWrap.getLong();

        // 准备一个缓冲区用于存放密钥
        Memory keyBuffer = new Memory(32);
        // 从计算出的密钥地址读取密钥
        if (!kernel32.ReadProcessMemory(process, new Pointer(keyAddress), keyBuffer, (int) keyBuffer.size(), bytesRead)) {
            return null;
        }

        // 将密钥转换为十六进制字符串
        StringBuilder sb = new StringBuilder();
        byte[] key = keyBuffer.getByteArray(0, 32);
        try (Formatter formatter = new Formatter(sb)) {
            for (byte b : key) {
                formatter.format("%02x", b & 0xff);
            }
        }
        // 返回密钥的十六进制表示
        return sb.toString();
    }

    /**
     * 样子秘钥是否正确
     *
     * @param password 秘钥
     * @param dbFile   被验证的文件
     * @return 是否验证成功
     */
    private boolean verifyKey(String password, String dbFile) {
        // 创建File文件
        File file = new File(dbFile);

        try (FileInputStream fis = new FileInputStream(file)) {
            // 文件大小
            byte[] fileContent = new byte[5000];
            // 读取内容
            fis.read(fileContent);

            // 提取盐值
            byte[] salt = Arrays.copyOfRange(fileContent, 0, 16);
            // 提取第一页
            byte[] firstPage = Arrays.copyOfRange(fileContent, 16, 4096);
            // 提取第一页的内容与IV
            byte[] firstPageBodyAndIv = Arrays.copyOfRange(firstPage, 0, firstPage.length - 32);
            // 提取第一页的hashMac
            byte[] firstPageHashMac = Arrays.copyOfRange(firstPage, firstPage.length - 32, firstPage.length - 12);

            // 生成key
            byte[] key = Pbkdf2HmacUtil.pbkdf2Hmac(HexUtil.decodeHex(password), salt, 64000, 32);

            byte[] macSalt = new byte[salt.length];
            for (int i = 0; i < salt.length; i++) {
                macSalt[i] = (byte) (salt[i] ^ 58);
            }
            // 秘钥匹配成功
            return Pbkdf2HmacUtil.checkKey(key, macSalt, firstPageHashMac, firstPageBodyAndIv);
        } catch (Exception e) {
            log.error("Verification key failed", e);
        }
        return false;
    }

    /**
     * 列出并检索进程中指定已加载模块
     *
     * @param process 目标进程
     */
    private List<Psapi.MODULEINFO> enumProcessModule(WinNT.HANDLE process) {
        List<Psapi.MODULEINFO> moduleInfos = new ArrayList<>();
        // 获取模块句柄列表
        WinNT.HMODULE[] hModules = new WinNT.HMODULE[1024];
        // 指针大小
        int cbNeeded = hModules.length * Native.POINTER_SIZE;
        // 存储所有模块句柄所需的字节数
        IntByReference read = new IntByReference();
        // 调用 EnumProcessModules 方法
        boolean success = Psapi.INSTANCE.EnumProcessModules(process, hModules, cbNeeded, read);
        // 读取模块失败
        if (!success) {
            log.warn("EnumProcessModules failed. Error code: " + Native.getLastError());
            return moduleInfos;
        }
        // 遍历加载到的所有模块
        for (WinDef.HMODULE hModule : hModules) {
            // 模块不等于空的情况下
            if (hModule != null) {
                // 获取模块信息
                Psapi.MODULEINFO moduleInfo = new Psapi.MODULEINFO();
                // 加载模块的详细信息
                boolean moduleInformationSuccess = Psapi.INSTANCE.GetModuleInformation(process, hModule, moduleInfo, moduleInfo.size());
                // 读取失败
                if (!moduleInformationSuccess) {
                    log.warn("GetModuleInformation failed. Error code: " + Native.getLastError());
                    continue;
                }
                moduleInfos.add(moduleInfo);
            }
        }
        return moduleInfos;
    }

    /**
     * 通过模块名检索指定进程加载的模块信息
     *
     * @param process 指定的进程句柄
     * @return 包含模块信息的 Psapi.MODULEINFO 对象，如果未找到，则返回 null
     */
    private Psapi.MODULEINFO moduleFromName(WinNT.HANDLE process) {
        // 列出并检索进程中指定已加载模块
        List<Psapi.MODULEINFO> moduleInfos = enumProcessModule(process);

        // 遍历模块列表
        for (Psapi.MODULEINFO moduleInfo : moduleInfos) {
            // 创建用于存储模块文件名的字节数组
            byte[] buffer = new byte[WinNT.MAX_PATH];

            // 根据模块的基址创建模块句柄
            WinNT.HANDLE handle = new WinNT.HANDLE(moduleInfo.lpBaseOfDll);

            // 获取模块文件名并存储在 buffer 中
            Psapi.INSTANCE.GetModuleFileNameExA(process, handle, buffer, buffer.length);

            // 截取字符串，去除多余的字节，得到模块文件名
            byte[] trimmedBytes = ArrayUtil.sub(buffer, 0, ArrayUtil.indexOf(buffer, (byte) 0));

            // 获得文件名
            String fileName = new String(trimmedBytes, Charset.defaultCharset());

            // 判断模块文件名是否以指定的模块名结尾
            if (fileName.endsWith(WeChatServiceImpl.MODULE_NAME)) {
                return moduleInfo;
            }
        }
        // 未找到匹配的模块，返回 null
        return null;
    }

    /**
     * 在指定进程的指定模块中，通过模式扫描查找匹配的内存地址
     *
     * @param process 指定的进程句柄
     * @param pattern 要扫描的模式字节数组
     * @return 包含匹配的内存地址的列表
     */
    private List<Pointer> patternScanModule(WinNT.HANDLE process, byte[] pattern) {
        // 用于存储找到的内存地址的列表
        List<Pointer> foundPointers = new ArrayList<>();

        // 通过模块名检索指定进程加载的模块信息
        Psapi.MODULEINFO moduleInfo = moduleFromName(process);

        // 空校验
        if (moduleInfo == null) {
            return foundPointers;
        }

        // 获取模块基址和模块最大地址
        long baseAddress = Pointer.nativeValue(moduleInfo.lpBaseOfDll);
        long maxAddress = Pointer.nativeValue(moduleInfo.lpBaseOfDll) + moduleInfo.SizeOfImage;
        long pageAddress = baseAddress;

        // 循环扫描模块内存页
        while (pageAddress < maxAddress) {
            // 扫描当前页的模式，并返回下一个扫描的起始地址和匹配的内存地址列表
            Pair<Long, List<Pointer>> pair = scanPatternPage(process, pageAddress, pattern);
            pageAddress = pair.getLeft();

            // 如果找到了匹配的内存地址，则添加到列表中
            if (pair.getRight() != null) {
                foundPointers.addAll(pair.getRight());
            }
        }
        // 返回找到的内存地址列表
        return foundPointers;
    }

    /**
     * 获取微信目录
     *
     * @return 微信文件目录
     */
    public String getBasePath() {
        // 默认微信文件路径设为 "MyDocument:"
        String wechatDir = MY_DOCUMENT;
        // 是否读取成功的标记
        boolean readSuccess = false;

        try {
            // 尝试从注册表读取 WeChat 的文件保存路径
            if (Advapi32Util.registryKeyExists(WinReg.HKEY_CURRENT_USER, WECHAT_REG_PATH)) {
                // 如果成功读取，设置 wechatDir 为读取的路径
                wechatDir = Advapi32Util.registryGetStringValue(WinReg.HKEY_CURRENT_USER, WECHAT_REG_PATH, FILE_SAVE_PATH);
                // 标记为读取成功
                readSuccess = true;
            }
        } catch (Exception ignore) {
            // 如果读取失败，设路径为 "MyDocument:"
            wechatDir = MY_DOCUMENT;
        }


        // 如果从注册表读取失败，尝试从配置文件读取
        try {
            if (!readSuccess) {
                // 获取用户主目录
                String userProfile = System.getenv("USERPROFILE");
                // 拼接 WeChat 配置文件的完整路径
                String configPath = userProfile + CONFIG_FILE_PATH;
                // 读取配置文件的所有行
                List<String> lines = Files.readAllLines(Paths.get(configPath));

                if (!lines.isEmpty()) {
                    // 如果文件不为空，设置 wechatDir 为读取的第一行内容
                    wechatDir = lines.get(0);
                }
            }
        } catch (IOException e) {
            // 如果读取失败，设路径为 "MyDocument:"
            wechatDir = MY_DOCUMENT;
        }

        // 如果路径为 "MyDocument:"，尝试设置为Documents目录
        if (MY_DOCUMENT.equals(wechatDir)) {
            try {
                // 获取文档目录路径
                char[] documentsPath = new char[WinDef.MAX_PATH];
                // 尝试获取文档目录路径
                int documentsPathSuccess = Shell32.INSTANCE.SHGetFolderPath(null, ShlObj.CSIDL_PERSONAL, null, ShlObj.SHGFP_TYPE_CURRENT, documentsPath).intValue();
                // 如果成功获取文档目录路径
                if (documentsPathSuccess == WinError.S_OK.intValue()) {
                    // 成功获取文档目录路径后，设置 wechatDir 为文档目录路径
                    wechatDir = Native.toString(documentsPath);
                } else {
                    // 如果获取失败，设置路径为用户主目录下的 "Documents"
                    wechatDir = System.getenv("USERPROFILE") + "\\Documents";
                }
            } catch (Exception e) {
                // 如果获取失败，设置路径为用户主目录下的 "Documents"
                wechatDir = System.getenv("USERPROFILE") + "\\Documents";
            }
        }
        // 拼接 WeChat 文件目录路径
        return wechatDir + WECHAT_FILES_DIR;
    }

    /**
     * 根据进程ID获取微信ID。
     *
     * @param pid 目标进程ID
     * @return 微信ID
     */
    @Override
    public String getWxId(int pid) {
        // 获取Kernel32实例
        Kernel32 kernel32 = Kernel32.INSTANCE;
        // 打开目标进程句柄
        WinNT.HANDLE process = kernel32.OpenProcess(0x1F0FFF, false, pid);
        // 设置要匹配的模式字符串
        String pattern = "\\Msg\\FTSContact";
        // 在目标进程中扫描符合模式的内存位置
        List<Pointer> addresses = patternScanAll(process, pattern, 10);
        // 遍历匹配到的内存位置
        for (Pointer address : addresses) {
            // 分配内存作为缓冲区读取数据
            int bufferSize = 80;
            Memory buffer = new Memory(bufferSize);
            IntByReference read = new IntByReference();
            // 从指定地址的前一部分开始读取内存，而不是从地址的确切位置开始。
            Pointer offsetPointer = new Pointer(Pointer.nativeValue(address) - 30);
            // 从指定地址读取内存数据
            boolean success = kernel32.ReadProcessMemory(process, offsetPointer, buffer, bufferSize, read);
            if (success) {
                // 将读取的字节转换为字符串
                byte[] dataBytes = buffer.getByteArray(0, read.getValue());
                String data = new String(dataBytes, 0, read.getValue());
                // 对字符串进行处理，提取微信ID信息
                data = data.split("\\\\Msg")[0];
                // 通过文件分隔符分割
                String[] newData = data.split("\\\\");
                // 取最后一个为微信Id
                return newData[newData.length - 1];
            }
        }
        // 关闭目标进程句柄
        kernel32.CloseHandle(process);
        // 返回空
        return null;
    }

    /**
     * 在指定进程的虚拟地址空间中扫描所有符合指定模式的内存位置。
     *
     * @param process 指定进程的句柄
     * @param pattern 要匹配的模式字符串
     * @param findNum 最大匹配数量
     * @return 符合模式的内存位置列表
     */
    public List<Pointer> patternScanAll(WinNT.HANDLE process, String pattern, int findNum) {
        // 存储符合模式的内存位置列表
        List<Pointer> found = new ArrayList<>();
        // 根据系统架构设置用户空间限制
        long userSpaceLimit = "amd64".equals(System.getProperty("os.arch")) ? 0x7FFFFFFF0000L : 0x7FFF0000L;
        // 初始下一个扫描位置
        long nextRegion = 0;
        // 循环扫描直到达到用户空间限制或找到足够的匹配位置
        while (nextRegion < userSpaceLimit) {
            // 执行单页扫描，获取扫描结果
            Pair<Long, List<Pointer>> pair = scanPatternPage(process, nextRegion, pattern.getBytes());
            // 更新下一个扫描位置
            nextRegion = pair.getLeft();
            // 获取单页扫描的匹配位置列表
            List<Pointer> pageFound = pair.getRight();

            // 如果单页扫描找到匹配位置，将其添加到总的匹配位置列表中
            if (!pageFound.isEmpty()) {
                found.addAll(pageFound);
            }
            // 如果找到足够的匹配位置，跳出循环
            if (found.size() > findNum) {
                break;
            }
        }
        // 返回符合模式的内存位置列表
        return found;
    }

    /**
     * 扫描内存页
     *
     * @param process      指定进程的句柄
     * @param startAddress 开始的内存地址
     * @param pattern      要匹配的模式字符串
     * @return Pair
     */
    private Pair<Long, List<Pointer>> scanPatternPage(WinNT.HANDLE process, long startAddress, byte[] pattern) {
        // 获取内存基本信息
        WinNT.MEMORY_BASIC_INFORMATION mbi = new WinNT.MEMORY_BASIC_INFORMATION();
        // 查询指定虚拟内存地址
        Kernel32.INSTANCE.VirtualQueryEx(process, new Pointer(startAddress), mbi, new BaseTSD.SIZE_T(mbi.size()));
        // 计算下一个内存区域的起始地址
        long nextRegion = Pointer.nativeValue(mbi.baseAddress) + mbi.regionSize.longValue();
        // 定义允许的内存保护标志
        int[] allowedProtections = {WinNT.PAGE_EXECUTE, WinNT.PAGE_EXECUTE_READ, WinNT.PAGE_EXECUTE_READWRITE, WinNT.PAGE_READWRITE, WinNT.PAGE_READONLY};

        List<Pointer> foundPointer = new ArrayList<>();

        // 检查内存状态和保护标志是否符合要求
        if (!(mbi.state.intValue() == WinNT.MEM_COMMIT && ArrayUtil.contains(allowedProtections, mbi.protect.intValue()))) {
            return Pair.of(nextRegion, foundPointer);
        }

        // 创建一个 Native Memory 对象，用于存储从进程中读取的内存数据
        Memory memory = new Memory(mbi.regionSize.intValue());
        // 创建一个引用对象，用于存储 ReadProcessMemory 函数返回的已读取字节数
        IntByReference bytesRead = new IntByReference();
        // 从指定进程中读取内存数据，并将结果存储到 Native Memory 对象中
        Kernel32.INSTANCE.ReadProcessMemory(process, new Pointer(startAddress), memory, mbi.regionSize.intValue(), bytesRead);
        // 从 Native Memory 对象中获取已读取的字节数，并创建一个字节数组存储读取的内存数据
        byte[] buffer = memory.getByteArray(0, bytesRead.getValue());

        // 查找匹配的模式在内存中的起始位置
        for (int start : findMatches(buffer, pattern)) {
            foundPointer.add(new Pointer(startAddress + start));
        }
        return Pair.of(nextRegion, foundPointer);
    }

    /**
     * 在字节数组中查找匹配指定模式的位置索引数组。
     *
     * @param inputBytes   待查找的字节数组
     * @param patternBytes 要匹配的模式字节数组
     * @return 匹配位置索引数组
     */
    private int[] findMatches(byte[] inputBytes, byte[] patternBytes) {
        // 初始化匹配位置索引数组
        int[] matches = new int[0];

        // 遍历待查找的字节数组
        for (int i = 0; i <= inputBytes.length - patternBytes.length; i++) {
            // 假设当前位置开始存在匹配
            boolean match = true;

            // 遍历模式字节数组，检查是否与待查找的子数组匹配
            for (int j = 0; j < patternBytes.length; j++) {
                if (inputBytes[i + j] != patternBytes[j]) {
                    // 如果有不匹配的字节，标记为不匹配，并中断内层循环
                    match = false;
                    break;
                }
            }
            // 如果找到匹配的位置，将其添加到匹配位置索引数组中
            if (match) {
                int[] newMatches = new int[matches.length + 1];
                System.arraycopy(matches, 0, newMatches, 0, matches.length);
                newMatches[matches.length] = i;
                matches = newMatches;
            }
        }
        // 返回匹配位置索引数组
        return matches;
    }

    /**
     * 获取指定进程ID的可执行文件版本。
     *
     * @param pid 进程ID。
     * @return 文件的版本号，如果无法获取，则返回 null。
     */
    @Override
    public String getVersion(int pid) {
        // 获取指定进程ID的可执行文件路径。
        String filePath = getExecutablePath(pid);

        // 用于存储 'GetFileVersionInfoSize' 函数的额外信息（通常未使用）。
        IntByReference dwDummy = new IntByReference();
        dwDummy.setValue(0);

        // 获取文件版本信息的大小。
        int versionLength = Version.INSTANCE.GetFileVersionInfoSize(filePath, dwDummy);
        // 如果长度为0，表示没有版本信息。
        if (versionLength == 0) {
            return null;
        }

        // 分配足够存储文件版本信息的缓冲区。
        byte[] buffer = new byte[versionLength];
        // 使用 JNA 的 Memory 类将缓冲区映射到内存。
        Pointer lpData = new Memory(buffer.length);
        // 获取文件版本信息。
        if (!Version.INSTANCE.GetFileVersionInfo(filePath, 0, versionLength, lpData)) {
            return null;
        }

        // 用于存储 'VerQueryValue' 函数输出的文件版本信息指针。
        PointerByReference lplpBuffer = new PointerByReference();
        // 用于存储 'VerQueryValue' 函数输出的文件版本信息长度。
        IntByReference puLen = new IntByReference();

        // 查询具体的文件版本信息。
        if (Version.INSTANCE.VerQueryValue(lpData, "\\", lplpBuffer, puLen)) {
            // 将指针映射到 VS_FIXEDFILEINFO 结构。
            VerRsrc.VS_FIXEDFILEINFO lplpBufStructure = new VerRsrc.VS_FIXEDFILEINFO(lplpBuffer.getValue());
            lplpBufStructure.read();

            // 提取文件版本的主要部分和次要部分。
            long v1 = (lplpBufStructure.dwFileVersionMS.longValue() >> 16) & 0xffff;
            long v2 = lplpBufStructure.dwFileVersionMS.longValue() & 0xffff;
            long v3 = (lplpBufStructure.dwFileVersionLS.longValue() >> 16) & 0xffff;
            long v4 = lplpBufStructure.dwFileVersionLS.longValue() & 0xffff;

            // 组合并返回版本字符串。
            return v1 + "." + v2 + "." + v3 + "." + v4;
        }

        // 如果无法查询到版本信息，返回 null。
        return null;
    }

    /**
     * 获取给定进程ID的可执行文件路径。
     *
     * @param pid 进程ID。
     * @return 可执行文件的完整路径，如果无法获取，则返回 null。
     */
    private String getExecutablePath(int pid) {
        // 获取 Kernel32 实例，用于访问 Windows API 函数。
        Kernel32 kernel32 = Kernel32.INSTANCE;

        // 打开进程以查询信息。PROCESS_QUERY_INFORMATION 和 PROCESS_VM_READ
        // 是所需的访问权限，以获取进程的可执行文件路径。
        WinNT.HANDLE process = kernel32.OpenProcess(WinNT.PROCESS_QUERY_INFORMATION | WinNT.PROCESS_VM_READ, false, pid);

        try {
            // 确保成功获取到进程句柄。
            if (process != null) {
                // 分配字符数组以存储路径。
                char[] path = new char[WinDef.MAX_PATH];
                // 初始化大小为路径的最大长度。
                int size = path.length;
                // 调用 QueryFullProcessImageName 获取进程的完整路径。
                boolean success = Kernel32.INSTANCE.QueryFullProcessImageName(process, 0, path, new IntByReference(size));
                // 如果成功获取路径，返回路径字符串。
                if (success) {
                    return new String(path).trim();
                }
            }
        } finally {
            // 确保在操作完成后关闭进程句柄。
            if (process != null) {
                kernel32.CloseHandle(process);
            }
        }
        // 如果无法获取路径，返回 null。
        return null;
    }

    /**
     * 去掉点比较版本号的方法
     *
     * @param supportMinVersion 支持的版本
     * @param currentVersion    当前版本
     * @return true or false
     */
    private boolean compareVersions(String supportMinVersion, String currentVersion) {
        long supportMinVersionLong = Long.parseLong(supportMinVersion.replaceAll("\\.", ""));
        long currentVersionLong = Long.parseLong(currentVersion.replaceAll("\\.", ""));
        return currentVersionLong < supportMinVersionLong;
    }
}
