package com.powernode.spring6.bean;

/**
 * 工廠方法模式當中的：具體工廠角色。
 **/
public class GunFactory {
    // 工廠方法模式中的具體工廠角色中的方法是：實例方法。
    public Gun get() {
        // 實際上new這個物件還是我們自己new的。
        return new Gun();
    }
}
