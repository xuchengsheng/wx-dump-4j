package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * TopContactsVO
 *
 * @author xcs
 * @date 2024年01月06日 15时38分
 **/
@Data
public class TopContactsVO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String headImgUrl;

    /**
     * total
     */
    private Long total;
}
