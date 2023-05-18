package com.powernode.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService { // 目標物件(Target)
    // 目標方法
    // 轉帳的業務方法
    public void transfer(){
        System.out.println("銀行帳戶正在完成轉帳操作...");
    }

    // 目標方法
    // 取款的業務方法
    public void withdraw(){
        System.out.println("正在取款，請稍後...");
    }
}