package com.powernode.spring6.service;

import com.powernode.spring6.dao.OrderDao;

public class OrderService {

    private OrderDao orderDao;

    // 通過set方法給屬性賦值
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * 生成訂單的業務方法
     */
    public void generate(){
        orderDao.insert();
    }
}
