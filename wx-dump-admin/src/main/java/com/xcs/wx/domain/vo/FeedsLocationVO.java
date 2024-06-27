package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * FeedsLocationVO
 *
 * @author xcs
 * @date 2024年01月04日 14时25分
 **/
@Data
public class FeedsLocationVO {

    /**
     * poiClassifyId
     */
    private String poiClassifyId;

    /**
     * poiName
     */
    private String poiName;

    /**
     * poiAddress
     */
    private String poiAddress;

    /**
     * poiClassifyType
     */
    private Integer poiClassifyType;

    /**
     * city
     */
    private String city;
}
