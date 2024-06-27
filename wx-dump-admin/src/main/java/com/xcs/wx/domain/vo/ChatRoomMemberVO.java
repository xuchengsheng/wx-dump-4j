package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * ChatRoomMemberVO
 *
 * @author xcs
 * @date 2024年01月08日 16时10分
 **/
@Data
public class ChatRoomMemberVO {

    /**
     * wxId
     */
    private String wxId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 备注
     */
    private Integer state;

    /**
     * 头像
     */
    private String headImgUrl;
}
