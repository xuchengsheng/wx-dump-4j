package com.xcs.wx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 朋友圈
 *
 * @author xcs
 * @date 2024年01月03日 16时41分
 **/
@Data
@TableName(value = "FeedsV20", autoResultMap = true)
public class Feeds {

    /**
     * 动态的唯一标识ID。
     */
    @TableId("FeedId")
    private Long feedId;

    /**
     * 创建时间，存储为整数形式。
     */
    @TableField("CreateTime")
    private Integer createTime;

    /**
     * 故障ID，用于记录相关故障信息。
     */
    @TableField("FaultId")
    private Integer faultId;

    /**
     * 动态的类型。
     */
    @TableField("Type")
    private Integer type;

    /**
     * 发布用户的用户名。
     */
    @TableField("UserName")
    private String userName;

    /**
     * 动态的状态。
     */
    @TableField("Status")
    private Integer status;

    /**
     * 扩展标志，用于存储额外信息。
     */
    @TableField("ExtFlag")
    private Integer extFlag;

    /**
     * 隐私标志，指示动态的隐私级别。
     */
    @TableField("PrivFlag")
    private Integer privFlag;

    /**
     * 字符串ID，可能用于关联其他数据。
     */
    @TableField("StringId")
    private String stringId;

    /**
     * 动态的内容文本。
     */
    @TableField("Content")
    private String content;
}
