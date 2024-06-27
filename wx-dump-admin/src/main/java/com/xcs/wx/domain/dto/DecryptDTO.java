package com.xcs.wx.domain.dto;

import lombok.Data;

/**
 * DecryptDTO
 *
 * @author xcs
 * @date 2023年12月31日15:25:21
 */
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

    /**
     * 版本号
     */
    private String version;

    /**
     * 账号
     */
    private String account;

    /**
     * 手机号
     */
    private String mobile;
}
