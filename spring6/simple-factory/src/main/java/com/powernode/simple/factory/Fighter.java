package com.powernode.simple.factory;

/**
 * 具體產品角色
 **/
public class Fighter extends Weapon {
    @Override
    public void attack() {
        System.out.println("戰鬥機抛下物資！！！！");
    }
}
