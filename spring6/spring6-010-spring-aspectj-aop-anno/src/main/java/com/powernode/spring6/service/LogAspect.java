package com.powernode.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 切面(Aspect)
@Component
@Aspect
@Order(2)
public class LogAspect {
    // 切面(Aspect) = 通知(Advice) + 切點(pointcut)
    // 通知就是增強，就是具體要編寫的增加代碼
    // 這里通知Advice以方法的形式出現。 （因為方法中可以寫代碼）

    // @Before標註的方法就是一個前置通知。
//    @Before("execution(* com.powernode.spring6.service..*(..))")
//    public void enhance() {
//        System.out.println("我是一個通知，是一段增強代碼....");
//    }

    // =================================================================
    // 定義通用的切點表達式
    @Pointcut("execution(public * com.powernode.spring6.service..*(..))")
    public void pointcut() {
        // 這個方法只是一個標記，方法名隨意，方法體中也不需要寫任何代碼
    }

    // 前置通知
    @Before("pointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("前置通知");
        // 這個JoinPoint joinPoint，在Spring容器調用這個方法的時候自動傳過來
        // 可以直接使用，用這個JoinPoint joinPoint 可以做甚麼?
        // Signature signature = joinPoint.getSignature();
        // 通過方法的signature可以獲得方法的具體信息
        System.out.println("目標方法的方法名：" + joinPoint.getSignature().getName());
    }

    // 後置通知
    @AfterReturning("pointcut()")
    public void afterReturningAdvice() {
        System.out.println("後置通知");
    }

    // 環繞通知(環繞是最大的通知，在前置通知之前，在後置通知之後。)
    // 環繞通知
    @Around("pointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前面代碼
        System.out.println("前環繞");
        // 執行目標
        joinPoint.proceed(); // 執行目標
        // 後面代碼
        System.out.println("後環繞");
    }

    // 異常通知
    @AfterThrowing("pointcut()")
    public void afterThrowingAdvice() {
        System.out.println("異常通知");
    }

    // 最終通知 (finally 語句塊中的通知)
    @After("pointcut()")
    public void afterAdvice() {
        System.out.println("最終通知");
    }

}