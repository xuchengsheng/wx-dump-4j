package com.xcs.wx.domain.bo;

import lombok.Data;

/**
 * @author xcs
 * @date 2023年12月28日 18时18分
 **/
@Data
public class MsgExtraBO {

    /**
     * 微信Id
     */
    private String wxId;

    /**
     * 图片
     */
    private String image;

    /**
     * 缩略图
     */
    private String thumb;
}
