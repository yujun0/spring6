package com.powernode.reflect;

import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws Exception {
        // 獲取類
        Class<?> clazz = Class.forName("com.powernode.reflect.SomeService");
        // 獲取方法
        Method doSomeMethod = clazz.getDeclaredMethod("doSome");
        // 調用方法
        doSomeMethod.invoke(clazz.newInstance());
    }
}