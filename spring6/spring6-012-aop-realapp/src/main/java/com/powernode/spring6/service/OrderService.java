package com.powernode.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService { // 目標物件 (Target)
    // 目標方法
    // 生成訂單的業務方法
    public void generate() {
        System.out.println("正在生成訂單...");
    }

    // 目標方法
    // 取消訂單的業務方法
    public void cancel() {
        System.out.println("訂單已取消...");
        String s = null;
        s.toString();
    }
}