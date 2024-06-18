package com.xcs.wx.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * RecoverContactDTO
 *
 * @author xcs
 * @date 2024年6月14日15:29:54
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class RecoverContactDTO extends PageDTO{

    /**
     * nickname
     */
    private String nickname;

    /**
     * c2remark
     */
    private String remark;
}
