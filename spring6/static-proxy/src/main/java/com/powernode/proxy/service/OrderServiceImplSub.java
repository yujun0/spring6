package com.powernode.proxy.service;

// =========================================================================
// 解決方案二：編寫業務類的子類，讓子類繼承業務類，對每個業務方法進行Override。
// =========================================================================
public class OrderServiceImplSub extends OrderServiceImpl {
    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        super.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        super.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        super.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");
    }
}