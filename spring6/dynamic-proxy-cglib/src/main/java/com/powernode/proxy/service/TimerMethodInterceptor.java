package com.powernode.proxy.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 前面增強
        long begin = System.currentTimeMillis();
        // 怎麼調用目標物件的目標方法呢？
        Object returnValue = methodProxy.invokeSuper(target, objects);
        // 後面增強
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");

        return returnValue;
    }
}