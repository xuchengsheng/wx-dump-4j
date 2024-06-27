package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * ChatRoomInfoVO
 *
 * @author xcs
 * @date 2024年01月09日 15时27分
 **/
@Data
public class ChatRoomInfoVO {

    /**
     * 聊天室公告内容。
     */
    private String announcement;

    /**
     * 信息版本号，默认为 0。
     */
    private Integer infoVersion;

    /**
     * 公告编辑者。
     */
    private String announcementEditor;

    /**
     * 公告发布人
     */
    private String announcementPublisher;

    /**
     * 公告发布时间，存储为时间戳，默认为 0。
     */
    private Long announcementPublishTime;

    /**
     * 公告发布时间
     */
    private String strAnnouncementPublishTime;

    /**
     * 聊天室状态，默认为 0。
     */
    private Integer chatRoomStatus;
}
