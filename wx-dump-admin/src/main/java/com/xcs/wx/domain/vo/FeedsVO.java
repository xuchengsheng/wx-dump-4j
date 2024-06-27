package com.xcs.wx.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * FeedsVO
 *
 * @author xcs
 * @date 2024年01月03日 16时41分
 **/
@Data
public class FeedsVO {

    /**
     * 动态的唯一标识ID。
     */
    private Long feedId;

    /**
     * 创建时间，存储为整数形式。
     */
    @JsonIgnore
    private Integer createTime;

    /**
     * 创建时间
     */
    private String strCreateTime;

    /**
     * 故障ID，用于记录相关故障信息。
     */
    private Integer faultId;

    /**
     * 动态的类型。
     */
    private Integer type;

    /**
     * 发布用户的用户名。
     */
    private String userName;

    /**
     * 发布用户的用户名。
     */
    private String nickName;

    /**
     * 动态的状态。
     */
    private Integer status;

    /**
     * 扩展标志，用于存储额外信息。
     */
    private Integer extFlag;

    /**
     * 隐私标志，指示动态的隐私级别。
     */
    private Integer privFlag;

    /**
     * 字符串ID，可能用于关联其他数据。
     */
    private String stringId;

    /**
     * 动态的内容文本。
     */
    @JsonIgnore
    private String content;

    /**
     * 内容描述
     */
    private String contentDesc;

    /**
     * 媒体内容
     */
    private List<FeedsMediaVO> medias;

    /**
     * 位置
     */
    private FeedsLocationVO location;

    /**
     * 联系人头像
     */
    private String headImgUrl;
}
