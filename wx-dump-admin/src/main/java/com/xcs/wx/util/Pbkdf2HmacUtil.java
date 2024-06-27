package com.xcs.wx.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Pbkdf2Hmac算法工具类
 *
 * @author xcs
 * @date 2023年12月25日 09时35分
 **/
public class Pbkdf2HmacUtil {

    private Pbkdf2HmacUtil() {
    }

    /**
     * 算法
     */
    private static final String ALGORITHM = "HmacSHA1";

    /**
     * 使用HMAC算法进行PBKDF2密钥派生
     *
     * @param password   用户的密码
     * @param salt       加盐值，用于增加加密的复杂度
     * @param iterations 迭代次数，增加计算量以抵抗暴力破解
     * @param dkLen      生成的密钥长度
     * @return 派生出的密钥
     * @throws NoSuchAlgorithmException InvalidKeyException 抛出异常
     */
    public static byte[] pbkdf2Hmac(byte[] password, byte[] salt, int iterations, int dkLen) throws NoSuchAlgorithmException, InvalidKeyException {
        // 初始化Mac实例
        Mac mac = Mac.getInstance(ALGORITHM);
        // 使用密码和算法初始化Mac
        mac.init(new SecretKeySpec(password, ALGORITHM));

        // 用于存储最终结果的数组
        byte[] result = new byte[dkLen];
        // 用于存储盐值和计数器的数组
        byte[] block = new byte[salt.length + 4];

        // 将盐值复制到block数组
        System.arraycopy(salt, 0, block, 0, salt.length);

        // 主循环，对每个派生块进行处理
        for (int i = 1; i <= (dkLen + mac.getMacLength() - 1) / mac.getMacLength(); i++) {
            // 在block数组的盐值后面添加计数器
            block[salt.length] = (byte) (i >>> 24);
            block[salt.length + 1] = (byte) (i >>> 16);
            block[salt.length + 2] = (byte) (i >>> 8);
            block[salt.length + 3] = (byte) i;

            // 计算第一次迭代的结果U
            byte[] u = mac.doFinal(block);
            // T数组，用于存储异或结果
            byte[] t = u.clone();

            // 内循环，进行额外的迭代以增加安全性
            for (int j = 1; j < iterations; j++) {
                // 对U再次进行HMAC运算
                u = mac.doFinal(u);
                // 将结果U与T进行异或，累加迭代结果
                for (int k = 0; k < t.length; k++) {
                    t[k] ^= u[k];
                }
            }
            // 将T的内容复制到最终结果数组中
            System.arraycopy(t, 0, result, (i - 1) * mac.getMacLength(), Math.min(t.length, dkLen - (i - 1) * mac.getMacLength()));
        }
        // 返回最终的密钥
        return result;
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
    public static boolean checkKey(byte[] byteKey, byte[] macSalt, byte[] hashMac, byte[] message) throws Exception {
        // 使用PBKDF2算法生成MAC密钥
        byte[] macKey = pbkdf2Hmac(byteKey, macSalt, 2, 32);
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
