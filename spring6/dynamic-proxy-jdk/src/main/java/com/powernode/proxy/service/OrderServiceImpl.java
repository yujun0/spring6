package com.powernode.proxy.service;

public class OrderServiceImpl implements OrderService{ // 目標物件

    @Override
    public String getName() {
        System.out.println("getName()方法執行了");
        return "Lisa";
    }

    @Override
    public void generate() { // 目標方法
        // 模擬生成訂單的耗時
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("訂單已生成.");
    }

    @Override
    public void modify() { // 目標方法
        // 模擬修改訂單的耗時
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("訂單已修改.");
    }

    @Override
    public void detail() { // 目標方法
        // 模擬查詢訂單的耗時
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("請看訂單詳情.");
    }
}