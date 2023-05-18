package com.powernode.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0) // 數字越小，優先級越高。
public class SecurityAspect { // 安全切面
    // 通知 + 切點
    @Before("com.powernode.spring6.service.LogAspect.pointcut()")
    public void beforeAdvice() {
        System.out.println("前置通知：安全...");
    }
}
