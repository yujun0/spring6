package com.powernode.spring6.bean;

public class Cat {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }
}
