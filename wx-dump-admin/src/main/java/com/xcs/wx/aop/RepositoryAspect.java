package com.xcs.wx.aop;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.xcs.wx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
                DynamicDataSourceContextHolder.push(SpringUtil.getBean(UserService.class).currentUser() + "#" + dsAnnotation.value());
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
