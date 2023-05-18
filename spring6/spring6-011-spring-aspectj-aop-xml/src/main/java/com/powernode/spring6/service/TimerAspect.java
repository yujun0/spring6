package com.powernode.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAspect {

    // 通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前環繞
        long begin = System.currentTimeMillis();
        // 目標
        joinPoint.proceed();
        // 後環繞
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");
    }
}