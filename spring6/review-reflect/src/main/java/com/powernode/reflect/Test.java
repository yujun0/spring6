package com.powernode.reflect;

public class Test {

    public static void main(String[] args) {
        // 不使用反射機制調用這些方法
        SomeService someService = new SomeService();
        someService.doSome();
        /**
         * 分析：調用一個方法，當中含有幾個要素？四要素。
         * 1. 調用哪個物件
         * 2. 調用哪個方法
         * 3. 調用方法的時候傳什麼參數
         * 4. 方法執行結果之後返回什麼值
         *
         * 調用哪個物件的哪個方法，傳什麼參數，返回什麼值。
         *
         * 即使是使用反射機制調用方法，也同樣需要具備這四個要素。
         */
        String s1 = someService.doSome("Lisa");
        System.out.println(s1);

        String s2 = someService.doSome("Susan", 250);
        System.out.println(s2);
    }

}