package com.xcs.wx.domain.dto;

import lombok.Data;

@Data
public class DecryptDTO {

    /**
     * pid
     */
    private int pid;

    /**
     * 文件目录
     */
    private String basePath;

    /**
     * 微信Id
     */
    private String wxId;

    /**
     * 昵称
     */
    private String nickname;
}
