package com.powernode.proxy.util;

import com.powernode.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyUtil {

    // Utility classes should not have public constructors
    private ProxyUtil() {
    }

    /**
     * 封裝一個工具方法，可以通過這個方法獲取代理物件。
     */
    public static Object newProxyInstance(Object target) {
        // 底層是調用的還是JDK的動態代理。
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
    }

}