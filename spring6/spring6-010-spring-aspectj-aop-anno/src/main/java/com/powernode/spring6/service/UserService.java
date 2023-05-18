package com.powernode.spring6.service;

import org.springframework.stereotype.Service;

// Target目標類
@Service
public class UserService {

    public void login() { // 目標方法
        System.out.println("系統正在進行身份認證....");
    }

    public void logout() {
        System.out.println("退出系統...");
    }

}