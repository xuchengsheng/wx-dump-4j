package com.xcs.wx.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DecryptBO
 *
 * @author xcs
 * @date 2023年12月10日20:21:02
 */
@Data
@AllArgsConstructor
public class DecryptBO {

    /**
     * 输入要解密的文件
     */
    private String input;

    /**
     * 解密后的文件
     */
    private String output;
}
