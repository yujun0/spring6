package com.powernode.spring6.bean;

public class People {
    private String name;
    private int age;
    private boolean sex;

    // c命名空間是簡化構造注入的。
    // c命名空間注入辦法是基於構造方法的。
    public People(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", sex=" + sex +
               '}';
    }
}
