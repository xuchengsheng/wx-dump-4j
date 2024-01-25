package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * @author xcs
 * @date 2023年12月21日 18时13分
 **/
@Data
public class DecryptVO {

    /**
     * 输入文件
     */
    private String input;

    /**
     * 输出文件
     */
    private String output;
}
