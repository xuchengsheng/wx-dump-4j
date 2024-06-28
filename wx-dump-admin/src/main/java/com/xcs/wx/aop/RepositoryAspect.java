package com.xcs.wx.aop;

import cn.hutool.core.annotation.AnnotationUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.xcs.wx.util.DSNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 多微信数据源动态切换拦截
 *
 * @author xcs
 * @date 2024年6月27日14:29:32
 */
@Slf4j
@Aspect
@Component
public class RepositoryAspect {

    @Around("execution(public * com.xcs.wx.repository..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String previousDs = DynamicDataSourceContextHolder.peek();
        try {
            // 获取拦截方法所在的类
            Class<?> targetClass = joinPoint.getTarget().getClass();
            // 获取类上的@DS注解
            DS dsAnnotation = AnnotationUtil.getAnnotation(targetClass, DS.class);
            // 有指定的注解
            if (dsAnnotation != null) {
                DynamicDataSourceContextHolder.push(DSNameUtil.getDSName(dsAnnotation.value()));
            }
            return joinPoint.proceed();
        } finally {
            // 恢复之前的ds
            if (previousDs != null) {
                DynamicDataSourceContextHolder.push(previousDs);
            } else {
                DynamicDataSourceContextHolder.clear();
            }
        }
    }
}
