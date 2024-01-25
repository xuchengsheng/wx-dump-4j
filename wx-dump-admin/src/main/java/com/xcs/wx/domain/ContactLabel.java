package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 联系人标签
 *
 * @author xcs
 * @date 2023年12月22日 16时53分
 **/
@Data
@TableName("ContactLabel")
public class ContactLabel {

    /**
     * 标签Id
     */
    @TableId("LabelId")
    private String labelId;

    /**
     * 标签名称
     */
    @TableField("LabelName")
    private String labelName;

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
     * 预留字段5。
     */
    @TableField("Reserved5")
    private String reserved5;

    /**
     * 响应数据
     */
    @TableField("RespData")
    private String respData;

}
