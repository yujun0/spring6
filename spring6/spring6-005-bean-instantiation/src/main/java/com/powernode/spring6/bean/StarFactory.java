package com.powernode.spring6.bean;

/**
 * 簡單工廠模式中的工廠類角色。星工廠。
 **/
public class StarFactory {
    // 工廠類中有一個靜態方法。
    // 簡單工廠模式又叫做：靜態工廠方法模式。
    public static Star get() {
        // 這個Star物件最終實際上創建的時候還是我們負責new的物件。
        return new Star();
    }
}
