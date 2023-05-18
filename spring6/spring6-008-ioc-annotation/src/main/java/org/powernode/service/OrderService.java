package org.powernode.service;

import com.powernode.spring6.bean.Order;
import org.powernode.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    // @Autowired註解使用的時候，不需要指定任何屬性，直接使用這個註解即可。
    // 這個註解的作用是根據類型byType進行自動裝配。
//    @Autowired
//    private OrderDao orderDao;
//
//    public void generate() {
//        orderDao.insert();
//    }
    // ==========================================================================================
//    private OrderDao orderDao;
//
//    @Autowired
//    public void setOrderDao(OrderDao orderDao) {
//        this.orderDao = orderDao;
//    }
//
//    public void generate() {
//        orderDao.insert();
//    }
// ==========================================================================================
//    private OrderDao orderDao;
//
//    public OrderService(@Autowired OrderDao orderDao) {
//        this.orderDao = orderDao;
//    }
//
//    public void generate() {
//        orderDao.insert();
//    }
    // ==========================================================================================
    /**
     * 如果一個類當中構造方法只有一個，並且構造方法上的參數和屬性能夠對應上。 @Autowired註解可以省略。
     */

//    private OrderDao orderDao;
//
//    public OrderService(OrderDao orderDao) {
//        this.orderDao = orderDao;
//    }
//
//    public OrderService() {}
//
//    public void generate() {
//        orderDao.insert();
//    }
    // ==========================================================================================

    // 如果想解決以上問題，只能根據名字進行裝配。
    // @Autowired和@Qualifier聯合使用，可以根據名字進行裝配。

    @Autowired
//    @Qualifier("orderDaoImplForMySQL")
    @Qualifier("orderDaoImplForOracle")
    private OrderDao orderDao;

    public void generate() {
        orderDao.insert();
    }

}