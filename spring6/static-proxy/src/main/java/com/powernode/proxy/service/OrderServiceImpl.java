package com.powernode.proxy.service;

public class OrderServiceImpl implements OrderService { // 目標物件


    /**
     * 項目經理提出一個新的需求：要統計所有業務介面中每一個業務方法的耗時。
     * 解決方案一：硬編碼，在每一個業務介面中的每一個業務方法中直接添加統計耗時的程序。
     * 這種方案的缺點：
     * 缺點一：違背OCP開閉原則。
     * 缺點二：代碼沒有得到復用。 （相同的代碼寫了很多遍）
     * ----------------------------------------------------------------------------------------------------------
     * 解決方案二：編寫業務類的子類，讓子類繼承業務類，對每個業務方法進行重寫。
     * 缺點一：雖然解決了OCP開閉原則。但是這種方式會導致耦合度很高，因為採用了繼承關係。繼承關係是一種耦合度非常高的關係，不建議使用。
     * 缺點二：代碼沒有得到復用。 （相同的代碼寫了很多遍）
     * ----------------------------------------------------------------------------------------------------------
     * 解決方案三：代理模式。
     * 優點1：解決了OCP問題。
     * 優點2：採用代理模式的has a，可以降低耦合度。
     * ----------------------------------------------------------------------------------------------------------
     * 目前我們使用的是靜態代理，這個靜態代理的缺點是什麼？
     * 類爆炸。假設系統中有1000個介面，那麼每個介面都需要對應代理類，這樣類會急劇膨脹。不好維護。
     * 怎麼解決類爆炸問題？
     * 可以使用動態代理來解決這個問題。
     * ----------------------------------------------------------------------------------------------------------
     * 動態代理還是代理模式，只不過添加了字節碼生成技術，可以在內存中為我們動態的生成一個class字節碼，這個字節碼就是代理類。
     * 在內存中動態的生成字節碼代理類的技術，叫做：動態代理。
     */
// =========================================================================
// 解決方案一：硬編碼，在每一個業務介面中的每一個業務方法中直接添加統計耗時的程序。
// =========================================================================
//    @Override
//    public void generate() {
//        long begin = System.currentTimeMillis();
//        // 模擬生成訂單的耗時
//        try {
//            Thread.sleep(1234);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("訂單已生成.");
//        long end = System.currentTimeMillis();
//        System.out.println("耗時" + (end - begin) + "毫秒");
//    }
//
//    @Override
//    public void modify() {
//        long begin = System.currentTimeMillis();
//        // 模擬修改訂單的耗時
//        try {
//            Thread.sleep(456);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("訂單已修改.");
//        long end = System.currentTimeMillis();
//        System.out.println("耗時" + (end - begin) + "毫秒");
//    }
//
//    @Override
//    public void detail() {
//        long begin = System.currentTimeMillis();
//        // 模擬查詢訂單的耗時
//        try {
//            Thread.sleep(111);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("請看訂單詳情.");
//        long end = System.currentTimeMillis();
//        System.out.println("耗時" + (end - begin) + "毫秒");
//    }
    // ========================================================
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