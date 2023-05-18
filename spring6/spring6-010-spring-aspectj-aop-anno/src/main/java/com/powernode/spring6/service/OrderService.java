package com.powernode.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService { // Target 目標類
    // 目標方法
    public void generate() {
        System.out.println("系統正在生成訂單.....");
//        throw new RuntimeException("運行時異常");
    }
}