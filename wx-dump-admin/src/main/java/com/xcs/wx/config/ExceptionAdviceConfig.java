package com.xcs.wx.config;

import com.baomidou.dynamic.datasource.exception.CannotFindDataSourceException;
import com.xcs.wx.domain.vo.ResponseVO;
import com.xcs.wx.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xcs
 * @date 2023年12月25日 17时29分
 **/
@Slf4j
@RestControllerAdvice
@ResponseStatus(HttpStatus.OK)
public class ExceptionAdviceConfig {

    /**
     * 捕获BizException异常
     **/
    @ExceptionHandler(BizException.class)
    public ResponseVO<String> handleException(BizException e) {
        return ResponseVO.error(e.getCode(), e.getMsg());
    }

    /**
     * 捕获MyBatisSystemException异常
     **/
    @ExceptionHandler(MyBatisSystemException.class)
    public ResponseVO<String> myBatisSystemException(MyBatisSystemException e) {
        // 数据库未就绪状态
        if (e.getCause().getCause() instanceof CannotFindDataSourceException) {
            return ResponseVO.error(-1, "微信数据库未就绪状态,请先点击左侧解密工具进行数据解密！");
        }
        log.error("mybatis system exception", e);
        return ResponseVO.error(-1, "系统异常");
    }

    /**
     * 捕获RuntimeException异常
     **/
    @ExceptionHandler(RuntimeException.class)
    public ResponseVO<String> handleException(RuntimeException e) {
        log.error("runtime exception", e);
        return ResponseVO.error(-1, "系统异常");
    }

    /**
     * 捕获Exception异常
     **/
    @ExceptionHandler(Exception.class)
    public ResponseVO<String> handleException(Exception e) {
        log.error("exception", e);
        return ResponseVO.error(-1, "系统异常");
    }
}
