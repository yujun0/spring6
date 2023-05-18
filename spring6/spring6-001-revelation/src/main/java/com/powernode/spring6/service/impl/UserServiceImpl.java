package com.powernode.spring6.service.impl;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.service.UserService;

public class UserServiceImpl implements UserService {

    //private UserDao userDao = new UserDaoImplForMySQL();
    // MySQL換Oracle 需要修改為
    //private UserDao userDao = new UserDaoImplForOracle();

    private UserDao userDao;

    @Override
    public void deleteUser() {
        userDao.deleteById();
    }
}
