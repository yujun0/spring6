package com.powernode.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {
    // 編程式事務解決方案
    @Around("execution(* com.powernode.spring6.service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        try {
            // 前環繞
            System.out.println("開啟事務");
            // 執行目標
            joinPoint.proceed();
            // 後環繞
            System.out.println("提交事務");
        } catch (Throwable e) {
            System.out.println("回滾事務");
        }
    }
}