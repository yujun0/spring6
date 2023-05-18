package com.powernode.spring6.bean;

/**
 * 表示學生
 **/
public class Student {
    private String name;

    // 學生屬於哪個班級
    private Clazz clazz;

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    // 使用級聯屬性賦值，這個需要這個get方法。
    public Clazz getClazz() {
        return clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", clazz=" + clazz +
               '}';
    }
}
