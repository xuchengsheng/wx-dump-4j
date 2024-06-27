package com.xcs.wx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * WeChatConfigVO
 *
 * @author xcs
 * @date 2023年12月25日 09时38分
 **/
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class WeChatConfigVO {

    /**
     * 进程Id
     */
    private Integer pid;

    /**
     * 基址
     */
    private Long baseAddress;

    /**
     * 版本号
     */
    private String version;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 账号
     */
    private String account;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 文件目录
     */
    private String basePath;

    /**
     * 微信Id
     */
    private String wxId;
}
