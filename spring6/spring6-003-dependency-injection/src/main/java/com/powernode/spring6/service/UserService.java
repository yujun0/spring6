package com.powernode.spring6.service;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.VipDao;

/**
 * Bean
 **/
public class UserService {

    private UserDao userDao;
    private VipDao vipDao;

    public void setAbc(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    // set注入的話，必須提供一個set方法。
    // Spring容器會調用這個set方法，來給userDao屬性賦值。
    // 這邊寫一個set方法，不使用IDEA工俱生成的。不符合javabean規範。
    // 至少這個方法是以set單詞開始的。前三個字母不能隨便寫，必須是“set"
//    public void setMySQLUserDao(UserDao xyz) {
//        this.userDao = xyz;
//    }


    // 這個set方法是IDEA工具生成的，符合javabean規範。
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        // 保存用戶信息到資料庫
        userDao.insert();
        vipDao.insert();
    }
}
