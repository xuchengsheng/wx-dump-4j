package com.xcs.wx.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * UserVO
 *
 * @author xcs
 * @date 2023年12月10日20:21:02
 */
@Data
@AllArgsConstructor
public class UserVO {

    /**
     * wxId
     */
    private String wxId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 当前选中状态
     */
    private boolean current;
}
