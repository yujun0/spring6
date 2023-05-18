package com.powernode.factory.method;

/**
 * 具體產品角色
 **/
public class Dagger extends Weapon {

    @Override
    public void attack() {
        System.out.println("砍！！！");
    }
}
