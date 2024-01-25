package com.xcs.wx.config;

import com.baomidou.dynamic.datasource.exception.CannotFindDataSourceException;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.exception.BizException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xcs
 * @date 2023年12月25日 17时29分
 **/
@RestControllerAdvice
@ResponseStatus(HttpStatus.OK)
public class ExceptionAdviceConfig {

    /**
     * 捕获RuntimeException异常
     **/
    @ExceptionHandler(BizException.class)
    public ResponseVO<String> handleException(BizException e) {
        return ResponseVO.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(MyBatisSystemException.class)
    public ResponseVO<String> myBatisSystemException(MyBatisSystemException e) {
        if (e.getCause().getCause() instanceof CannotFindDataSourceException) {
            return ResponseVO.error(-1, "数据库未就绪状态,请先点击右侧同步按钮！");
        }
        e.printStackTrace();
        return ResponseVO.error(-1, "系统异常");
    }

    /**
     * 捕获RuntimeException异常
     **/
    @ExceptionHandler(RuntimeException.class)
    public ResponseVO<String> handleException(RuntimeException e) {
        e.printStackTrace();
        return ResponseVO.error(-1, "系统异常");
    }
}
