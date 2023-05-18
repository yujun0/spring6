package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {

    @Resource
    private AccountDao accountDao;

    // 1號
    // 負責查詢
    // 當前事務可以讀取到別的事務沒有提交的數據
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    // 對方事務提交之後的數據我才能讀取到。
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getByActno(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println("查詢到的帳戶信息：" + account);
    }

}