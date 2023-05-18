package com.powernode.spring6.bean;

import java.util.Date;

public class Dog {
    // 簡單類型
    private String name;
    private int age;
    // 非簡單類型
    private Date birth;

    // p命名空間注入底層還是set注入，只不過p命名空間注入可以讓spring配置變的更加簡單。
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", birth=" + birth +
               '}';
    }
}
