package com.powernode.simple.factory;

/**
 * 具體產品角色
 **/
public class Dagger extends Weapon {
    @Override
    public void attack() {
        System.out.println("攻擊！！！");
    }
}
