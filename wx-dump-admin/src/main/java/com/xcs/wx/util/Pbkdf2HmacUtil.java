package com.xcs.wx.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author xcs
 * @date 2023年12月25日 09时35分
 **/
public class Pbkdf2HmacUtil {

    /**
     * 使用HMAC算法进行PBKDF2密钥派生
     *
     * @param algorithm HMAC使用的哈希算法
     * @param password 用户的密码
     * @param salt 加盐值，用于增加加密的复杂度
     * @param iterations 迭代次数，增加计算量以抵抗暴力破解
     * @param dkLen 生成的密钥长度
     * @return 派生出的密钥
     * @throws Exception 抛出异常
     */
    public static byte[] pbkdf2Hmac(String algorithm, byte[] password, byte[] salt, int iterations, int dkLen) throws Exception {
        // 初始化Mac实例
        Mac mac = Mac.getInstance(algorithm);
        // 使用密码和算法初始化Mac
        mac.init(new SecretKeySpec(password, algorithm));

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
}
