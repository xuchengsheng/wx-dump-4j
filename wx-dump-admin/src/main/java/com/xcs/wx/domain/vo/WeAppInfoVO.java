package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * WeAppInfoVO
 *
 * @author xcs
 * @date 2024年01月17日 14时19分
 **/
@Data
public class WeAppInfoVO {

    /**
     * title
     */
    private String title;

    /**
     * sourceDisplayName
     */
    private String sourceDisplayName;

    /**
     * weAppIconUrl
     */
    private String weAppIconUrl;

    /**
     * weAppPageThumbRawUrl
     */
    private String weAppPageThumbRawUrl;
}
