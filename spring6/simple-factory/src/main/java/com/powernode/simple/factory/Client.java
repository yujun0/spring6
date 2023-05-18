package com.powernode.simple.factory;

/**
 * 這是客戶端程序
 **/
public class Client {
    public static void main(String[] args) {
        // 需要坦克
        // 對於我客戶端來說，坦克的生產細節，我不需要關心，我只需要向工廠索要即可。
        // 簡單工廠模式達到了什麼呢？職責分離。客戶端不需要關心產品的生產細節。
        // 客戶端只負責消費。工廠類負責生產。一個負責生產，一個負責消費。
        // 生產者和消費者分離了。這就是簡單工廠模式的作用。
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();
        // 需要匕首
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
        // 需要戰鬥機
        Weapon fighter = WeaponFactory.get("FIGHTER");
        fighter.attack();
    }
}
