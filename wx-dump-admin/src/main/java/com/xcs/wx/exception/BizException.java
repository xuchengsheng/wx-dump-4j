package com.xcs.wx.exception;

/**
 * 业务异常
 *
 * @author xcs
 * @date 2023年12月25日 17时38分
 **/
public class BizException extends BaseException {

    public BizException(Integer code, String msg) {
        super(code, msg);
    }
}
