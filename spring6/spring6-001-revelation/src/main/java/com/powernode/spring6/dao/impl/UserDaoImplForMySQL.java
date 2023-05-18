package com.powernode.spring6.dao.impl;

import com.powernode.spring6.dao.UserDao;

public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL資料庫正在刪除用戶信息......");
    }
}
