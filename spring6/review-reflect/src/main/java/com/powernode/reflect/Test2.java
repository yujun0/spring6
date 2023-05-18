package com.powernode.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test2 {

    public static void main(String[] args) throws Exception {
        // 使用反射機制怎麼調用方法。
        // 獲取類
        Class<?> clazz = Class.forName("com.powernode.reflect.SomeService");

        // 獲取方法
        // 在java中方法同名不同參數是可以的(多型)，所以只透過方法名是獲取不到方法，所以需要後面的可變動參數Class<?>... parameterTypes
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);

        // 調用方法
        // 四要素：調用哪個物件、哪個方法、傳什麼參數、返回什麼值。
        // obj 要素：哪個物件
        // doSomeMethod 要素：哪個方法
        // "Lisa", 250 要素：傳什麼參數
        // retValue 要素：返回什麼值。
//        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
//        Object o = declaredConstructor.newInstance();

        Object retValue = doSomeMethod.invoke(clazz.newInstance(), "Lisa", 250);

        System.out.println(retValue);
    }

}