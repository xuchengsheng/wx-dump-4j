package com.xcs.wx.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.xcs.wx.constant.DataSourceType;
import com.xcs.wx.domain.vo.UserVO;
import com.xcs.wx.repository.ContactHeadImgUrlRepository;
import com.xcs.wx.repository.ContactRepository;
import com.xcs.wx.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * UserService 实现类
 *
 * @author xcs
 * @date 2024年6月15日16:06:37
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ContactHeadImgUrlRepository contactHeadImgUrlRepository;
    private final ContactRepository contactRepository;

    @Override
    public String avatar() {
        String wxId = currentUser();
        // 空校验
        if (wxId == null) {
            return null;
        }
        return getAvatar(wxId);
    }

    @Override
    public String nickname() {
        String wxId = currentUser();
        // 空校验
        if (wxId == null) {
            return null;
        }
        return getNickName(wxId);
    }

    @Override
    public List<UserVO> allUser() {
        // 用户信息
        List<UserVO> userVOList = new ArrayList<>();
        // 获取微信Id
        List<String> wxIds = getWxIds();
        // 遍历
        for (String wxId : wxIds) {
            // 当前选中账号
            boolean current = wxId.equals(currentUser());
            // 头像
            String avatar = getAvatar(wxId);
            // 昵称
            String nickName = getNickName(wxId);
            // 用户信息
            userVOList.add(new UserVO(wxId, nickName, avatar, current));
        }
        return userVOList;
    }

    @Override
    public void switchUser(String wxId) {
        FileUtil.writeString(wxId, getUserConfigPath(), "UTF-8");
    }

    @Override
    public String currentUser() {
        String userConfigPath = getUserConfigPath();
        if (!FileUtil.exist(userConfigPath)) {
            return Optional.of(getWxIds()).filter(items -> !items.isEmpty()).map(items -> items.get(0)).orElse(null);
        }
        return FileUtil.readUtf8String(getUserConfigPath());
    }

    @Override
    public void saveBasePath(String wxId, String basePath) {
        String separator = FileSystems.getDefault().getSeparator();
        String path = System.getProperty("user.dir") + separator + "data" + separator + "db" + separator + wxId + separator + "path.config";
        FileUtil.writeString(basePath, path, "UTF-8");
    }

    @Override
    public String getBasePath(String wxId) {
        String separator = FileSystems.getDefault().getSeparator();
        String path = System.getProperty("user.dir") + separator + "data" + separator + "db" + separator + wxId + separator + "path.config";
        return FileUtil.readUtf8String(path);
    }

    /**
     * 获得User配置
     *
     * @return path
     */
    private static String getUserConfigPath() {
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 存储目录
        return userDir + separator + "data" + separator + "SwitchUser.config";
    }

    /**
     * 获取微信Id
     *
     * @return wxIds
     */
    private List<String> getWxIds() {
        // 用户信息
        List<String> userVOList = new ArrayList<>();
        // 获得工作目录
        String userDir = System.getProperty("user.dir");
        // 文件分隔符
        String separator = FileSystems.getDefault().getSeparator();
        // 存储目录
        String dbPath = userDir + separator + "data" + separator + "db";
        // 目录
        Path path = Paths.get(dbPath);
        // 查看目录是否存在
        if (!FileUtil.exist(path.toFile())) {
            return userVOList;
        }
        // 指定要扫描的目录
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            // 遍历
            for (Path entry : stream) {
                // 判断是否为文件夹
                if (FileUtil.isDirectory(entry)) {
                    userVOList.add(FileUtil.getName(entry));
                }
            }
        } catch (IOException e) {
            log.error("allUser error", e);
        }
        return userVOList;
    }

    /**
     * 根据wxId获取头像
     *
     * @param wxId wxId
     * @return 头像
     */
    private String getAvatar(String wxId) {
        DynamicDataSourceContextHolder.push(wxId + "#" + DataSourceType.MICRO_MSG_DB);
        String avatar = contactHeadImgUrlRepository.queryHeadImgUrlByUserName(wxId);
        DynamicDataSourceContextHolder.clear();
        return avatar;
    }

    /**
     * 根据wxId获取昵称
     *
     * @param wxId wxId
     * @return 昵称
     */
    private String getNickName(String wxId) {
        DynamicDataSourceContextHolder.push(wxId + "#" + DataSourceType.MICRO_MSG_DB);
        String nickName = contactRepository.getNickName(wxId);
        DynamicDataSourceContextHolder.clear();
        return nickName;
    }
}
