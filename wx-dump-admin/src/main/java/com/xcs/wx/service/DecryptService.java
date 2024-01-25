package com.xcs.wx.service;

import com.xcs.wx.domain.bo.DecryptBO;

/**
 * 解密服务
 *
 * @author xcs
 * @date 2023年12月10日19:27:01
 */
public interface DecryptService {

    /**
     * 解密
     *
     * @param password 秘钥
     * @param decryptBO    输入文件
     */
    void wechatDecrypt(String password, DecryptBO decryptBO);
}
