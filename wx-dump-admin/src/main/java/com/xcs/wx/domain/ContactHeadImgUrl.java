package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 联系人头像
 *
 * @author xcs
 * @date 2023年12月21日 18时31分
 **/
@Data
@TableName("ContactHeadImgUrl")
public class ContactHeadImgUrl {

    /**
     * 用户名
     */
    @TableId("usrName")
    private String usrName;

    /**
     * 小头像图片的URL地址
     */
    @TableField("smallHeadImgUrl")
    private String smallHeadImgUrl;

    /**
     * 大头像图片的URL地址
     */
    @TableField("bigHeadImgUrl")
    private String bigHeadImgUrl;

    /**
     * 头像图片的MD5校验值
     */
    @TableField("headImgMd5")
    private String headImgMd5;

    /**
     * 预留字段0，可能用于未来的扩展或特定的内部用途
     */
    @TableField("reverse0")
    private Integer reverse0;

    /**
     * 预留字段1，同样可能用于未来的扩展或特定的内部用途
     */
    @TableField("reverse1")
    private String reverse1;
}