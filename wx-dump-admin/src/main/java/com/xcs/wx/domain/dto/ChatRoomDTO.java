package com.xcs.wx.domain.dto;

import lombok.Data;

/**
 * @author xcs
 * @date 2024年01月08日 16时24分
 **/
@Data
public class ChatRoomDTO extends PageDTO{

    /**
     * 群聊标题
     */
    private String chatRoomTitle;

    /**
     * 群昵称
     */
    private String selfDisplayName;

    /**
     * 创建人
     */
    private String createBy;
}
