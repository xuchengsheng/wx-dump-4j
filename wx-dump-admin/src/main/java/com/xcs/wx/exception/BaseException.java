package com.xcs.wx.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xcs
 * @date 2023年12月25日 17时39分
 **/
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    /**
     * 错误编码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String msg;
}
