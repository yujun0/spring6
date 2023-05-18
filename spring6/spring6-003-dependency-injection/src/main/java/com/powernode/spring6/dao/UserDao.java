package com.powernode.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean
 **/
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert() {
        // System.out.println("資料庫正在保存用戶信息。");
        // 使用一下log4j2日誌框架
        logger.info("資料庫正在保存用戶信息。");
    }
}
