package com.xcs.wx.service.impl;

import cn.hutool.core.util.HexUtil;
import com.xcs.wx.domain.bo.DecryptBO;
import com.xcs.wx.service.DecryptService;
import com.xcs.wx.util.Pbkdf2HmacUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解密服务实现类
 *
 * @author xcs
 * @date 2023年12月25日11:09:07
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DecryptServiceImpl implements DecryptService {

    /**
     * SQLite数据库的文件头
     */
    private static final String SQLITE_FILE_HEADER = "SQLite format 3\u0000";

    /**
     * 算法
     */
    private static final String ALGORITHM = "HmacSHA1";

    /**
     * 一页的大小
     */
    private static final int DEFAULT_PAGESIZE = 4096;

    /**
     * 迭代次数
     */
    private static final int ITERATIONS = 64000;

    /**
     * Key长度
     */
    private static final int HASH_KEY_LENGTH = 32;

    @Override
    public void wechatDecrypt(String password, DecryptBO decryptBO) {
        // 创建File文件
        File file = new File(decryptBO.getInput());

        try (FileInputStream fis = new FileInputStream(file)) {
            // 文件大小
            byte[] fileContent = new byte[(int) file.length()];
            // 读取内容
            fis.read(fileContent);

            // 提取盐值
            byte[] salt = Arrays.copyOfRange(fileContent, 0, 16);
            // 提取第一页
            byte[] firstPage = Arrays.copyOfRange(fileContent, 16, DEFAULT_PAGESIZE);
            // 提取第一页的内容与IV
            byte[] firstPageBodyAndIv = Arrays.copyOfRange(firstPage, 0, firstPage.length - 32);
            // 提取第一页的内容
            byte[] firstPageBody = Arrays.copyOfRange(firstPage, 0, firstPage.length - 48);
            // 提取第一页IV
            byte[] firstPageIv = Arrays.copyOfRange(firstPage, firstPage.length - 48, firstPage.length - 32);
            // 提取第一页的hashMac
            byte[] firstPageHashMac = Arrays.copyOfRange(firstPage, firstPage.length - 32, firstPage.length - 12);
            // 提取第一页的保留字段
            byte[] firstPageReservedSegment = Arrays.copyOfRange(firstPage, firstPage.length - 48, firstPage.length);

            // 生成key
            byte[] key = Pbkdf2HmacUtil.pbkdf2Hmac(ALGORITHM, HexUtil.decodeHex(password), salt, ITERATIONS, HASH_KEY_LENGTH);

            byte[] macSalt = new byte[salt.length];
            for (int i = 0; i < salt.length; i++) {
                macSalt[i] = (byte) (salt[i] ^ 58);
            }
            // 秘钥匹配成功
            if (checkKey(key, macSalt, firstPageHashMac, firstPageBodyAndIv)) {
                File outputFile = new File(decryptBO.getOutput());
                File parentDir = outputFile.getParentFile();

                // 检查父目录是否存在，如果不存在，则创建
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }

                // 解密并写入新文件
                try (FileOutputStream deFile = new FileOutputStream(outputFile)) {
                    deFile.write(SQLITE_FILE_HEADER.getBytes());
                    deFile.write(doDecrypt(key, firstPageIv, firstPageBody));
                    deFile.write(firstPageReservedSegment);
                    // 解密后续数据块
                    for (byte[] page : splitDataPages(fileContent)) {
                        byte[] iv = Arrays.copyOfRange(page, page.length - 48, page.length - 32);
                        byte[] body = Arrays.copyOfRange(page, 0, page.length - 48);
                        byte[] reservedSegment = Arrays.copyOfRange(page, page.length - 48, page.length);
                        deFile.write(doDecrypt(key, iv, body));
                        deFile.write(reservedSegment);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用AES/CBC/NoPadding模式进行解密
     *
     * @param key   密钥
     * @param iv    初始化向量
     * @param input 待解密的数据
     * @return 解密后的数据
     * @throws GeneralSecurityException 抛出异常
     */
    private byte[] doDecrypt(byte[] key, byte[] iv, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(input);
    }

    /**
     * 将数据分割成多个页面
     *
     * @param fileContent 文件内容的字节数组
     * @return 分割后的页面列表
     */
    private List<byte[]> splitDataPages(byte[] fileContent) {
        List<byte[]> pages = new ArrayList<>();
        for (int i = DEFAULT_PAGESIZE; i < fileContent.length; i += DEFAULT_PAGESIZE) {
            // 计算每个分割页面的结束位置
            int end = Math.min(i + DEFAULT_PAGESIZE, fileContent.length);
            byte[] slice = new byte[end - i];
            // 将数据复制到新的页面中
            System.arraycopy(fileContent, i, slice, 0, slice.length);
            pages.add(slice);
        }
        return pages;
    }

    /**
     * 检查密钥是否有效
     *
     * @param byteKey 密钥的字节数组
     * @param macSalt MAC盐值
     * @param hashMac 预期的MAC哈希值
     * @param message 消息内容
     * @return 如果密钥有效返回true，否则返回false
     * @throws Exception 抛出异常
     */
    private boolean checkKey(byte[] byteKey, byte[] macSalt, byte[] hashMac, byte[] message) throws Exception {
        // 使用PBKDF2算法生成MAC密钥
        byte[] macKey = Pbkdf2HmacUtil.pbkdf2Hmac(ALGORITHM, byteKey, macSalt, 2, 32);
        Mac mac = Mac.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(macKey, ALGORITHM);
        mac.init(keySpec);
        // 更新MAC计算的消息内容
        mac.update(message);
        // 添加额外的数据到消息中
        mac.update(new byte[]{1, 0, 0, 0});
        // 比较计算出的MAC值和预期的MAC值是否相同
        return Arrays.equals(hashMac, mac.doFinal());
    }
}
