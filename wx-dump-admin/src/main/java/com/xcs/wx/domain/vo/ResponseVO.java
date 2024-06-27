package com.xcs.wx.domain.vo;

import lombok.Data;

/**
 * ResponseVO
 *
 * @author xcs
 * @date 2023年12月25日 17时31分
 **/
@Data
public class ResponseVO<T> {

    /**
     * 业务编码
     */
    private Boolean success;

    /**
     * 错误编码
     */
    private Integer errorCode;

    /**
     * 错误消息
     */
    private String errorMessage;

    /**
     * 页数
     */
    private Long page;

    /**
     * 总数量
     */
    private Long total;

    /**
     * 展示类型
     */
    private Integer showType;

    /**
     * 数据
     */
    private T data;

    /**
     * 成功
     *
     * @param data 数据
     * @param <T>  泛型对象
     * @return ResponseDTO
     */
    public static <T> ResponseVO<T> ok(T data) {
        ResponseVO<T> wrapper = new ResponseVO<>();
        wrapper.setSuccess(true);
        wrapper.setData(data);
        return wrapper;
    }

    /**
     * 成功
     *
     * @param data  数据
     * @param <T>   泛型对象
     * @param page  页数
     * @param total 总数量
     * @return ResponseDTO
     */
    public static <T> ResponseVO<T> ok(T data, Long page, Long total) {
        ResponseVO<T> wrapper = new ResponseVO<>();
        wrapper.setSuccess(true);
        wrapper.setData(data);
        wrapper.setPage(page);
        wrapper.setTotal(total);
        return wrapper;
    }

    /**
     * 失败
     *
     * @param <T> 数据
     * @return ResponseDTO
     */
    public static <T> ResponseVO<T> error(Integer errorCode, String errorMessage) {
        ResponseVO<T> wrapper = new ResponseVO<>();
        wrapper.setSuccess(false);
        wrapper.setErrorCode(errorCode);
        wrapper.setShowType(2);
        wrapper.setErrorMessage(errorMessage);
        return wrapper;
    }
}
