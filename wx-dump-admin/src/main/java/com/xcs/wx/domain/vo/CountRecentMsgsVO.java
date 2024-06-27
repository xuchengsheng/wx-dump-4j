package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * CountRecentMsgsVO
 *
 * @author xcs
 * @date 2024年01月06日 14时21分
 **/
@Data
public class CountRecentMsgsVO {

    /**
     * 类型
     */
    private String type;

    /**
     * 值
     */
    private Long value;

    /**
     * 分类
     */
    private String category;
}
