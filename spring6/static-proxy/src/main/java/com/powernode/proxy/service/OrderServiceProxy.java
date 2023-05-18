package com.powernode.proxy.service;

// =========================================================================
// 解決方案三：代理模式。
// =========================================================================
// 代理物件（代理物件和目標物件要具有相同的行為，就要實現同一個或同一些介面。）
// 客戶端在使用代理物件的時候就像在使用目標物件一樣。
public class OrderServiceProxy implements OrderService {

    // 將目標物件作為代理物件的一個屬性。這種關係叫做關聯關係，比繼承關係的耦合度低。
    // 代理物件中含有目標物件的引用。關聯關係。 has a
    // 注意：這裡要寫一個公共介面類型。因為公共介面耦合度低。
    private final OrderService target; // 這就是目標物件。目標物件一定是實現了OrderService介面的。

    // 創建代理物件的時候，傳一個目標物件給代理物件。
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() { // 代理方法
        // 增強
        long begin = System.currentTimeMillis();
        // 調用目標物件的目標方法
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() { // 代理方法
        // 增強
        long begin = System.currentTimeMillis();
        // 調用目標物件的目標方法
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() { // 代理方法
        // 增強
        long begin = System.currentTimeMillis();
        // 調用目標物件的目標方法
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");
    }
}