package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * FTSContactContent
 *
 * @author xcs
 * @date 2024年6月14日15:12:27
 **/
@Data
@TableName(value = "FTSContact15_content", autoResultMap = true)
public class FTSContactContent {

    /**
     * 本地唯一标识符，自增。
     */
    @TableId(value = "docid", type = IdType.AUTO)
    private Integer docId;

    /**
     * alias
     */
    @TableField("c0alias")
    private String alias;

    /**
     * nickname
     */
    @TableField("c1nickname")
    private String nickname;

    /**
     * c2remark
     */
    @TableField("c2remark")
    private String remark;
}
