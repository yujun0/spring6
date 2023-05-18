package com.powernode.spring6.bean;

public class User {
    private String username; // String是簡單類型
    private String password;
    private int age; // int是簡單類型

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", age=" + age +
               '}';
    }
}
