package com.xcs.wx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * MsgTypeDistributionVO
 *
 * @author xcs
 * @date 2024年01月05日 15时25分
 **/
@Data
@AllArgsConstructor
public class MsgTypeDistributionVO {

    /**
     * 类型
     */
    private String type;

    /**
     * 数量
     */
    private Integer value;
}
