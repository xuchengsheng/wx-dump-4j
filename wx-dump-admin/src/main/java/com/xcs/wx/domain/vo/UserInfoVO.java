package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * UserInfoVO
 *
 * @author xcs
 * @date 2024年6月28日16:13:53
 */
@Data
public class UserInfoVO {

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
