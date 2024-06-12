package com.xcs.wx.service;

import com.xcs.wx.domain.dto.DecryptDTO;

/**
 * 注册数据源
 *
 * @author xcs
 * @date 2023年12月25日19:28:37
 */
public interface DatabaseService {

    /**
     * 数据库解密
     */
    void decrypt(DecryptDTO decryptDTO);
}
