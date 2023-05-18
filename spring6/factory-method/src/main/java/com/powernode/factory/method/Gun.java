package com.powernode.factory.method;

/**
 * 具體產品角色
 **/
public class Gun extends Weapon {
    @Override
    public void attack() {
        System.out.println("開槍！！！");
    }
}
