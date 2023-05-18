package com.powernode.client;

import com.powernode.annotation.Component;

public class ReflectAnnotationTest {
    public static void main(String[] args) throws Exception {
        // 通過反射機制怎麼讀取註解
        // 獲取類
        Class<?> clazz = Class.forName("com.powernode.bean.User");
        // 判斷類上面有沒有這個註解
        if (clazz.isAnnotationPresent(Component.class)) {
            // 獲取類上的註解
            Component annotation = clazz.getAnnotation(Component.class);
            // 訪問註解屬性
            System.out.println("annotation.value() = " + annotation.value());
        }
    }
}