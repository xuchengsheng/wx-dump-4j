package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.ByteArrayTypeHandler;

/**
 * 视频链接表
 *
 * @author xcs
 * @date 2024年02月07日 15时24分
 **/
@Data
@TableName(value = "HardLinkVideoAttribute", autoResultMap = true)
public class HardLinkVideoAttribute {

    /**
     * 动态的唯一标识ID。
     */
    @TableId("Md5Hash")
    private Long md5Hash;

    /**
     * 发布用户的用户名。
     */
    @TableField("DirID1")
    private String dirId1;

    /**
     * 发布用户的用户名。
     */
    @TableField("DirID2")
    private String dirId2;

    /**
     * 发布用户的用户名。
     */
    @TableField(value = "Md5", typeHandler = ByteArrayTypeHandler.class)
    private byte[] md5;

    /**
     * 发布用户的用户名。
     */
    @TableField("ModifyTime")
    private String modifyTime;

    /**
     * 发布用户的用户名。
     */
    @TableField("FileName")
    private String fileName;

}
