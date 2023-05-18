package com.powernode.spring6.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class SecurityLogAspect {

    @Pointcut("execution(* com.powernode.spring6.biz..save*(..))")
    public void savePointcut() {
    }

    @Pointcut("execution(* com.powernode.spring6.biz..delete*(..))")
    public void deletePointcut() {
    }

    @Pointcut("execution(* com.powernode.spring6.biz..modify*(..))")
    public void modifyPointcut() {
    }

    @Before("savePointcut() || deletePointcut() || modifyPointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 系統時間
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTime = sdf.format(new Date());
        // 輸出日誌信息
        System.out.println(nowTime + " Lisa : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}