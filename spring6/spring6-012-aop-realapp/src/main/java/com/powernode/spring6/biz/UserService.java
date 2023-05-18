package com.powernode.spring6.biz;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void saveUser() {
        System.out.println("新增用戶信息");
    }

    public void deleteUser() {
        System.out.println("刪除用戶信息");
    }

    public void modifyUser() {
        System.out.println("修改用戶信息");
    }

    public void getUser() {
        System.out.println("獲取用戶信息");
    }
}