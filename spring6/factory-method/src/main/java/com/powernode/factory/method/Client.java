package com.powernode.factory.method;

/**
 * 客戶端程序
 **/
public class Client {
    public static void main(String[] args) {
        WeaponFactory weaponFactory = new DaggerFactory();
        Weapon dagger = weaponFactory.get();
        dagger.attack();

        WeaponFactory weaponFactory1 = new GunFactory();
        Weapon gun = weaponFactory1.get();
        gun.attack();
    }
}
