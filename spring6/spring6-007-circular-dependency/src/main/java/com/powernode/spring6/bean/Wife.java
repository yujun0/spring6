package com.powernode.spring6.bean;

/**
 * 妻子類
 **/
public class Wife {
    private String name;
    private Husband husband;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    // toString()方法重寫時需要注意：不能直接輸出husband，輸出husband.getName()。要不然會出現遞歸導致的棧內存溢出錯誤。
    @Override
    public String toString() {
        return "Wife{" +
               "name='" + name + '\'' +
               ", husband=" + husband.getName() +
               '}';
    }

}
