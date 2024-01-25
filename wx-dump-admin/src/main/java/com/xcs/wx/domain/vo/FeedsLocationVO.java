package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * @author xcs
 * @date 2024年01月04日 14时25分
 **/
@Data
public class FeedsLocationVO {

    private String poiClassifyId;

    private String poiName;

    private String poiAddress;

    private Integer poiClassifyType;

    private String city;
}
