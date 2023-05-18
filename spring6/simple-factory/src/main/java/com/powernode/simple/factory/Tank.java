package com.powernode.simple.factory;

/**
 * 具體產品角色
 **/
public class Tank extends Weapon {
    @Override
    public void attack() {
        System.out.println("坦克射擊！！！");
    }
}
