package com.powernode.spring6.dao.impl;

import com.powernode.spring6.dao.UserDao;

public class UserDaoImplForOracle implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle資料庫正在刪除用戶資料....");
    }
}
