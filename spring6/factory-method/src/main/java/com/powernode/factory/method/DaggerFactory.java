package com.powernode.factory.method;

/**
 * 具體工廠角色
 **/
public class DaggerFactory extends WeaponFactory {
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
