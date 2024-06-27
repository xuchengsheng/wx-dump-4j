package com.xcs.wx.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * ChatRoomDetailVO
 *
 * @author xcs
 * @date 2024年01月08日 16时10分
 **/
@Data
public class ChatRoomDetailVO {

    /**
     * 群聊名称
     */
    private String chatRoomName;

    /**
     * 群聊标题
     */
    private String chatRoomTitle;

    /**
     * 自己在聊天室中的显示名称。
     */
    private String selfDisplayName;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 头像
     */
    private String headImgUrl;

    /**
     * 预留字段2
     */
    @JsonIgnore
    private String reserved2;

    /**
     * roomData
     */
    @JsonIgnore
    private byte[] roomData;

    /**
     * 群聊信息
     */
    private ChatRoomInfoVO chatRoomInfo;

    /**
     * 群成员
     */
    private List<ChatRoomMemberVO> members;
}
