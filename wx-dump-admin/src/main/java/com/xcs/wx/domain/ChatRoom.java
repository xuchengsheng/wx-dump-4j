package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.ByteArrayTypeHandler;

/**
 * 群聊
 *
 * @author xcs
 * @date 2024年01月08日 09时45分
 **/
@Data
@TableName(value = "ChatRoom", autoResultMap = true)
public class ChatRoom {

    /**
     * 聊天室名称，作为主键。
     */
    @TableId("ChatRoomName")
    private String chatRoomName;

    /**
     * 用户名列表，以文本形式存储。
     */
    @TableField("UserNameList")
    private String userNameList;

    /**
     * 显示名称列表，以文本形式存储。
     */
    @TableField("DisplayNameList")
    private String displayNameList;

    /**
     * 聊天室标志，默认为 0。
     */
    @TableField("ChatRoomFlag")
    private Integer chatRoomFlag;

    /**
     * 聊天室拥有者的标识，默认为 0。
     */
    @TableField("Owner")
    private Integer owner;

    /**
     * 是否显示名称的标志，默认为 0。
     */
    @TableField("IsShowName")
    private Integer isShowName;

    /**
     * 自己在聊天室中的显示名称。
     */
    @TableField("SelfDisplayName")
    private String selfDisplayName;

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
     * 聊天室数据，以 BLOB 形式存储。
     */
    @TableField(value = "RoomData", typeHandler = ByteArrayTypeHandler.class)
    private byte[] roomData;

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
