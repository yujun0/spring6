package com.powernode.spring6.bean;

/**
 * 這是一個Bean，封裝了用戶的信息。 Spring可以幫助我們創建User物件嗎？
 **/
public class User {
    // Spring是怎麼實例化物件的？
    // 默認情況下Spring會通過反射機制，調用class的 無參數 構造方法 來實例化物件。
    // 如果只有有參數構造方法沒有無參數構造方法，會創建不出來物件
    // 實現原理如下：
    // Class clazz = Class.forName("com.powernode.spring6.bean.User");
    // Object obj = clazz.newInstance();
    public User() {
        System.out.println("User的無參數構造方法執行。");
    }

    public User(String s) {}
}
