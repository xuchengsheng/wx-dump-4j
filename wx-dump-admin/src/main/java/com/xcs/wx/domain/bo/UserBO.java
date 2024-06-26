package com.xcs.wx.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * UserBO
 *
 * @author xcs
 * @date 2023年12月10日20:21:02
 */
@Data
@AllArgsConstructor
public class UserBO {

    /**
     * wxId
     */
    private String wxId;

    /**
     * 昵称
     */
    private String nickname;
}
