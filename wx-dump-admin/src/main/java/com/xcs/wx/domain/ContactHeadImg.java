package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.ByteArrayTypeHandler;

/**
 * 联系人头像表实体类
 *
 * @author xcs
 * @date 2023年12月22日 10时59分
 **/
@Data
@TableName("ContactHeadImg1")
public class ContactHeadImg {

    /**
     * 用户名，主键
     */
    @TableId("usrName")
    private String usrName;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Integer createTime;

    /**
     * 小头像数据
     */
    @TableField(value = "smallHeadBuf", typeHandler = ByteArrayTypeHandler.class)
    private byte[] smallHeadBuf;

    /**
     * 头像MD5值
     */
    @TableField("m_headImgMD5")
    private String headImgMd5;
}
