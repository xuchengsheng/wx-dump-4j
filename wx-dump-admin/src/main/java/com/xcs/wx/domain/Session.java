package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 会话
 *
 * @author xcs
 * @date 2023年12月21日 17时05分
 **/
@Data
@TableName("Session")
public class Session {

    /**
     * 用户名
     */
    @TableId("strUsrName")
    private String usrName;

    /**
     * 未读消息计数
     */
    @TableField("nUnReadCount")
    private Integer unReadCount;

    /**
     * 父引用，可能指向与此会话相关联的其他实体
     */
    @TableField("parentRef")
    private String parentRef;

    /**
     * 用户昵称
     */
    @TableField("strNickName")
    private String nickName;

    /**
     * 会话状态
     */
    @TableField("nStatus")
    private Integer status;

    /**
     * 发送状态标识
     */
    @TableField("nIsSend")
    private Integer isSend;

    /**
     * 会话内容
     */
    @TableField("strContent")
    private String content;

    /**
     * 消息类型
     */
    @TableField("nMsgType")
    private Integer msgType;

    /**
     * 本地消息ID
     */
    @TableField("nMsgLocalID")
    private Integer msgLocalId;

    /**
     * 消息状态
     */
    @TableField("nMsgStatus")
    private Integer msgStatus;

    /**
     * 消息时间戳
     */
    @TableField("nTime")
    private Integer time;

    /**
     * 编辑过的内容
     */
    @TableField("editContent")
    private String editContent;

    /**
     * 标记是否有其他人@我
     */
    @TableField("othersAtMe")
    private Integer othersAtMe;
}
