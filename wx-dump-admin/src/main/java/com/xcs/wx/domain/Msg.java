package com.xcs.wx.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.ByteArrayTypeHandler;

/**
 * 消息
 *
 * @author xcs
 * @date 2023年12月25日 15时08分
 **/
@Data
@TableName(value = "MSG", autoResultMap = true)
public class Msg {

    /**
     * 本地唯一标识符，自增。
     */
    @TableId(value = "localId",type = IdType.AUTO)
    private Integer localId;

    /**
     * 聊天对象的 ID。
     */
    @TableField("TalkerId")
    private Integer talkerId;

    /**
     * 消息服务器 ID。
     */
    @TableField("MsgSvrID")
    private String msgSvrId;

    /**
     * 消息类型。
     */
    @TableField("Type")
    private Integer type;

    /**
     * 消息子类型。
     */
    @TableField("SubType")
    private Integer subType;

    /**
     * 发送者标识（是否为发送者）。
     */
    @TableField("IsSender")
    private Integer isSender;

    /**
     * 消息创建时间。
     */
    @TableField("CreateTime")
    private Integer createTime;

    /**
     * 序列号，默认为 0。
     */
    @TableField("Sequence")
    private Long sequence;

    /**
     * 扩展状态，默认为 0。
     */
    @TableField("StatusEx")
    private Integer statusEx;

    /**
     * 扩展标志。
     */
    @TableField("FlagEx")
    private Integer flagEx;

    /**
     * 消息状态。
     */
    @TableField("Status")
    private Integer status;

    /**
     * 消息服务器序列号。
     */
    @TableField("MsgServerSeq")
    private Integer msgServerSeq;

    /**
     * 消息序列号。
     */
    @TableField("MsgSequence")
    private Integer msgSequence;

    /**
     * 聊天者字符串。
     */
    @TableField("StrTalker")
    private String strTalker;

    /**
     * 消息内容字符串。
     */
    @TableField("StrContent")
    private String strContent;

    /**
     * 显示内容。
     */
    @TableField("DisplayContent")
    private String displayContent;

    /**
     * 保留字段 0，默认为 0。
     */
    @TableField("Reserved0")
    private Integer reserved0;

    /**
     * 保留字段 1，默认为 0。
     */
    @TableField("Reserved1")
    private Integer reserved1;

    /**
     * 保留字段 2，默认为 0。
     */
    @TableField("Reserved2")
    private Integer reserved2;

    /**
     * 保留字段 3，默认为 0。
     */
    @TableField("Reserved3")
    private Integer reserved3;

    /**
     * 保留字段 4，文本类型。
     */
    @TableField("Reserved4")
    private String reserved4;

    /**
     * 保留字段 5，文本类型。
     */
    @TableField("Reserved5")
    private String reserved5;

    /**
     * 保留字段 6，文本类型。
     */
    @TableField("Reserved6")
    private String reserved6;

    /**
     * 压缩内容，二进制大对象。
     */
    @TableField(value = "CompressContent", typeHandler = ByteArrayTypeHandler.class)
    private byte[] compressContent;

    /**
     * 额外字节信息，二进制大对象。
     */
    @TableField(value = "BytesExtra", typeHandler = ByteArrayTypeHandler.class)
    private byte[] bytesExtra;

    /**
     * 传输字节信息，二进制大对象。
     */
    @TableField(value = "BytesTrans", typeHandler = ByteArrayTypeHandler.class)
    private byte[] bytesTrans;
}
