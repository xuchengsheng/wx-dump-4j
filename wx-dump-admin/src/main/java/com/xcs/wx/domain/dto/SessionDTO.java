package com.xcs.wx.domain.dto;

import lombok.Data;

/**
 * @author xcs
 * @date 2023年12月29日 17时41分
 **/
@Data
public class SessionDTO extends PageDTO{

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 会话内容
     */
    private String content;
}
