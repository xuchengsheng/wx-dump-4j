package com.xcs.wx.domain.dto;

import lombok.Data;

/**
 * @author xcs
 * @date 2023年12月31日15:25:21
 */
@Data
public class ContactDTO extends PageDTO{

    /**
     * 备注
     */
    private String remark;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 标签Id
     */
    private String labels;

    /**
     * 描述
     */
    private String describe;
}
