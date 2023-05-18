package com.powernode.proxy.service;

/**
 * 訂單業務介面
 **/
public interface OrderService { // 代理物件和目標物件的公共介面。

    /**
     * 生成訂單
     */
    void generate();

    /**
     * 修改訂單信息
     */
    void modify();

    /**
     * 查看訂單詳情
     */
    void detail();

}