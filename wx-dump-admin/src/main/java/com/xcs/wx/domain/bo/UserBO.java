package com.xcs.wx.domain.bo;

import lombok.Builder;
import lombok.Data;

/**
 * UserBO
 *
 * @author xcs
 * @date 2023年12月31日15:25:21
 */
@Data
@Builder
public class UserBO {

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
