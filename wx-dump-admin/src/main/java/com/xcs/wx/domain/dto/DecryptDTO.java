package com.xcs.wx.domain.dto;

import lombok.Data;

@Data
public class DecryptDTO {

    /**
     * 秘钥
     */
    private String key;

    /**
     * 文件目录
     */
    private String basePath;

    /**
     * 微信Id
     */
    private String wxId;
}
