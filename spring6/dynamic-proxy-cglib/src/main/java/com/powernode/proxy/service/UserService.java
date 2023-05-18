package com.powernode.proxy.service;

/**
 * 目標類
 **/
public class UserService {
    // 目標方法
    public boolean login(String username, String password) {
        System.out.println("系統正在驗證身份...");
        return "admin".equals(username) && "123".equals(password);
    }

    // 目標方法
    public void logout() {
        System.out.println("系統正在退出...");
    }
}