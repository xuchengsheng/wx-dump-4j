package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 群聊信息
 *
 * @author xcs
 * @date 2024年01月09日 14时53分
 **/
@Data
@TableName("ChatRoomInfo")
public class ChatRoomInfo {

    /**
     * 聊天室名称，作为主键。
     */
    @TableId("ChatRoomName")
    private String chatRoomName;

    /**
     * 聊天室公告内容。
     */
    @TableField("Announcement")
    private String announcement;

    /**
     * 信息版本号，默认为 0。
     */
    @TableField("InfoVersion")
    private Integer infoVersion;

    /**
     * 公告编辑者。
     */
    @TableField("AnnouncementEditor")
    private String announcementEditor;

    /**
     * 公告发布时间，存储为时间戳，默认为 0。
     */
    @TableField("AnnouncementPublishTime")
    private Long announcementPublishTime;

    /**
     * 聊天室状态，默认为 0。
     */
    @TableField("ChatRoomStatus")
    private Integer chatRoomStatus;

    /**
     * 预留字段1。
     */
    @TableField("Reserved1")
    private Integer reserved1;

    /**
     * 预留字段2。
     */
    @TableField("Reserved2")
    private String reserved2;

    /**
     * 预留字段3。
     */
    @TableField("Reserved3")
    private Integer reserved3;

    /**
     * 预留字段4。
     */
    @TableField("Reserved4")
    private String reserved4;

    /**
     * 预留字段5。
     */
    @TableField("Reserved5")
    private Integer reserved5;

    /**
     * 预留字段6。
     */
    @TableField("Reserved6")
    private String reserved6;

    /**
     * 预留字段7。
     */
    @TableField("Reserved7")
    private Integer reserved7;

    /**
     * 预留字段8。
     */
    @TableField("Reserved8")
    private String reserved8;
}
