package com.xcs.wx.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * FeedsDTO
 *
 * @author xcs
 * @date 2024年01月03日 17时17分
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class FeedsDTO extends PageDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;
}
