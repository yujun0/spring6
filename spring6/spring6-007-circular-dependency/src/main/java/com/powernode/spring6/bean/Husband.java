package com.powernode.spring6.bean;

/**
 * 丈夫類
 **/
public class Husband {
    private String name;
    private Wife wife;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    // toString()方法重寫時需要注意：不能直接輸出wife，輸出wife.getName()。要不然會出現遞歸導致的棧內存溢出錯誤。
    @Override
    public String toString() {
        return "Husband{" +
               "name='" + name + '\'' +
               ", wife=" + wife.getName() +
               '}';
    }

}
