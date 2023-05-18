package com.powernode.simple.factory;

/**
 * 工廠類角色
 **/
public class WeaponFactory {
    /**
     * 靜態方法
     * 要獲取什麼產品 -> 就看你傳什麼參數，傳TANK獲取坦克，傳DAGGER獲取匕首，傳FIGHTER獲取戰鬥機
     * 簡單工廠模式中有一個靜態方法，所以被稱為：靜態工廠方法模式。
     *
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType) {
        if ("TANK".equalsIgnoreCase(weaponType)) {
            return new Tank();
        } else if ("DAGGER".equalsIgnoreCase(weaponType)) {
            return new Dagger();
        } else if ("FIGHTER".equalsIgnoreCase(weaponType)) {
            return new Fighter();
        } else {
            throw new RuntimeException("不支持該武器的生產");
        }
    }

}
