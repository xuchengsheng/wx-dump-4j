package com.xcs.wx.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * ChatRoomVO
 *
 * @author xcs
 * @date 2024年01月08日 16时10分
 **/
@Data
public class ChatRoomVO {

    /**
     * 聊天室名称
     */
    private String chatRoomName;

    /**
     * 群聊标题
     */
    private String chatRoomTitle;

    /**
     * 是否显示名称的标志
     */
    private Integer isShowName;

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
     * 群聊是否已经解散
     */
    private Boolean dissolution;

    /**
     * 是否为企业微信群
     */
    private Boolean enterprise;

    /**
     * 群聊数据
     */
    @JsonIgnore
    private byte[] roomData;

    /**
     * 群聊人数
     */
    private Integer memberCount;
}
