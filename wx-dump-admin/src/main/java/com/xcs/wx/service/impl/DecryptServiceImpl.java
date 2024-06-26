package com.xcs.wx.service.impl;

import cn.hutool.core.util.HexUtil;
import com.xcs.wx.domain.bo.DecryptBO;
import com.xcs.wx.service.DecryptService;
import com.xcs.wx.util.Pbkdf2HmacUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.security.GeneralSecurityException;
import java.util.Arrays;

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

        try (FileChannel fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ)) {
            // 文件大小
            long fileSize = file.length();
            MappedByteBuffer fileContent = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);

            // 提取盐值
            byte[] salt = new byte[16];
            fileContent.get(salt);
            // 提取第一页
            byte[] firstPage = new byte[DEFAULT_PAGESIZE - 16];
            fileContent.get(firstPage);

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
            byte[] key = Pbkdf2HmacUtil.pbkdf2Hmac(HexUtil.decodeHex(password), salt, ITERATIONS, HASH_KEY_LENGTH);

            byte[] macSalt = new byte[salt.length];
            for (int i = 0; i < salt.length; i++) {
                macSalt[i] = (byte) (salt[i] ^ 58);
            }
            // 秘钥匹配成功
            if (Pbkdf2HmacUtil.checkKey(key, macSalt, firstPageHashMac, firstPageBodyAndIv)) {
                File outputFile = new File(decryptBO.getOutput());
                File parentDir = outputFile.getParentFile();

                // 检查父目录是否存在，如果不存在，则创建
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }

                // 解密并写入新文件
                try (FileChannel outChannel = FileChannel.open(outputFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                    ByteBuffer headerBuffer = ByteBuffer.wrap(SQLITE_FILE_HEADER.getBytes());
                    outChannel.write(headerBuffer);

                    ByteBuffer decryptedFirstPage = ByteBuffer.wrap(doDecrypt(key, firstPageIv, firstPageBody));
                    ByteBuffer reservedSegmentBuffer = ByteBuffer.wrap(firstPageReservedSegment);

                    // 创建暂存缓冲区
                    ByteBuffer tempBuffer = ByteBuffer.allocate((int) fileSize);

                    // 写入第一页的解密内容和保留字段到暂存缓冲区
                    tempBuffer.put(decryptedFirstPage);
                    tempBuffer.put(reservedSegmentBuffer);

                    // 解密后续数据块
                    while (fileContent.hasRemaining()) {
                        byte[] page = new byte[DEFAULT_PAGESIZE];
                        fileContent.get(page);

                        // 判断是否是填充页面，如果是则跳过后续处理
                        if (isPaddingPage(page)) {
                            break;
                        }

                        byte[] iv = Arrays.copyOfRange(page, page.length - 48, page.length - 32);
                        byte[] body = Arrays.copyOfRange(page, 0, page.length - 48);
                        byte[] reservedSegment = Arrays.copyOfRange(page, page.length - 48, page.length);

                        ByteBuffer decryptedBody = ByteBuffer.wrap(doDecrypt(key, iv, body));
                        ByteBuffer reservedSegmentBuf = ByteBuffer.wrap(reservedSegment);

                        // 将解密内容和保留字段写入暂存缓冲区
                        tempBuffer.put(decryptedBody);
                        tempBuffer.put(reservedSegmentBuf);
                    }

                    // 将暂存缓冲区内容写入到输出文件
                    tempBuffer.flip();
                    outChannel.write(tempBuffer);
                }
            }
        } catch (Exception e) {
            log.error("WeChat decryption failed", e);
        }
    }

    /**
     * 检查页面是否为填充页面
     *
     * @param page 页面数据
     * @return 如果是填充页面返回true，否则返回false
     */
    private boolean isPaddingPage(byte[] page) {
        for (byte b : page) {
            if (b != 0) {
                return false;
            }
        }
        return true;
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
}
