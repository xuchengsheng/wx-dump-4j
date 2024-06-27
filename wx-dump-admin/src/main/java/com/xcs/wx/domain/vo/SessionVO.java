package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * SessionVO
 *
 * @author xcs
 * @date 2023年12月21日 18时13分
 **/
@Data
public class SessionVO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 会话内容
     */
    private String content;

    /**
     * 消息时间戳
     */
    private Integer time;

    /**
     * 短时间
     */
    private String shortTime;

    /**
     * 头像Url
     */
    private String headImgUrl;
}
