package com.xcs.wx.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * ContactVO
 *
 * @author xcs
 * @date 2023年12月22日 14时43分
 **/
@Data
public class ContactVO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 别名。
     */
    private String alias;

    /**
     * 备注信息。
     */
    private String remark;

    /**
     * 昵称。
     */
    private String nickName;

    /**
     * 描述
     */
    private String describe;

    /**
     * 头像
     */
    private String headImgUrl;

    /**
     * 标签Id
     */
    private String labelIdList;

    /**
     * 标签
     */
    private List<String> labels;
}
