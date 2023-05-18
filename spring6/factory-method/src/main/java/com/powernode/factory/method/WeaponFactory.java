package com.powernode.factory.method;

/**
 * 抽象工廠角色
 **/
public abstract class WeaponFactory {

    /**
     * 這個方法不是靜態的。是實例方法
     */
    public abstract Weapon get();

}
