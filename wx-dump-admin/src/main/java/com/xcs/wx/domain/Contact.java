package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.ByteArrayTypeHandler;

/**
 * 联系人
 *
 * @author xcs
 * @date 2023年12月22日 10时59分
 **/
@Data
@TableName(value = "Contact",autoResultMap = true)
public class Contact {

    /**
     * 用户名，作为主键。
     */
    @TableId(value = "UserName")
    private String userName;

    /**
     * 别名。
     */
    @TableField("Alias")
    private String alias;

    /**
     * 加密用户名。
     */
    @TableField("EncryptUserName")
    private String encryptUserName;

    /**
     * 删除标志，默认为0。
     */
    @TableField("DelFlag")
    private Integer delFlag;

    /**
     * 类型，默认为0。
     */
    @TableField("Type")
    private Integer type;

    /**
     * 验证标志，默认为0。
     */
    @TableField("VerifyFlag")
    private Integer verifyFlag;

    /**
     * 预留字段1。
     */
    @TableField("Reserved1")
    private Integer reserved1;

    /**
     * 预留字段2。
     */
    @TableField("Reserved2")
    private Integer reserved2;

    /**
     * 预留字段3。
     */
    @TableField("Reserved3")
    private String reserved3;

    /**
     * 预留字段4。
     */
    @TableField("Reserved4")
    private String reserved4;

    /**
     * 备注信息。
     */
    @TableField("Remark")
    private String remark;

    /**
     * 昵称。
     */
    @TableField("NickName")
    private String nickName;

    /**
     * 标签ID列表。
     */
    @TableField("LabelIDList")
    private String labelIdList;

    /**
     * 域列表。
     */
    @TableField("DomainList")
    private String domainList;

    /**
     * 聊天室类型。
     */
    @TableField("ChatRoomType")
    private Integer chatRoomType;

    /**
     * 昵称的拼音首字母。
     */
    @TableField("PYInitial")
    private String pyInitial;

    /**
     * 昵称的完整拼音。
     */
    @TableField("QuanPin")
    private String quanPin;

    /**
     * 备注的拼音首字母。
     */
    @TableField("RemarkPYInitial")
    private String remarkPyInitial;

    /**
     * 备注的完整拼音。
     */
    @TableField("RemarkQuanPin")
    private String remarkQuanPin;

    /**
     * 大头像URL。
     */
    @TableField("BigHeadImgUrl")
    private String bigHeadImgUrl;

    /**
     * 小头像URL。
     */
    @TableField("SmallHeadImgUrl")
    private String smallHeadImgUrl;

    /**
     * 头像的MD5值。
     */
    @TableField("HeadImgMd5")
    private String headImgMd5;

    /**
     * 聊天室通知标志，默认为0。
     */
    @TableField("ChatRoomNotify")
    private Integer chatRoomNotify;

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
    private String reserved7;

    /**
     * 预留字段8。
     */
    @TableField("Reserved8")
    private Integer reserved8;

    /**
     * 预留字段9。
     */
    @TableField("Reserved9")
    private Integer reserved9;

    /**
     * 预留字段10。
     */
    @TableField("Reserved10")
    private String reserved10;

    /**
     * 预留字段11。
     */
    @TableField("Reserved11")
    private String reserved11;

    /**
     * 额外数据
     */
    @TableField(value = "ExtraBuf", typeHandler = ByteArrayTypeHandler.class)
    private byte[] extraBuf;
}
