package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service("i2")
public class IsolationService2 {

    @Resource
    private AccountDao accountDao;

    // 2號
    // 負責insert
    // @Transactional(timeout = 10)    // 設置事務超時時間為10秒。
    // @Transactional(rollbackFor = RuntimeException.class) // 只要發生RuntimeException或者這個異常的子類異常，都回滾。
    @Transactional(noRollbackFor = NullPointerException.class) // 當異常是空指針異常的時候不回滾
    public void save(Account act) throws IOException {
        // 睡眠一會
//        try {
//            Thread.sleep(1000 * 15);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.insert(act);

        // 模擬異常
        // throw new IOException();
        // throw new RuntimeException();
        throw new NullPointerException();
        // 可以在這裡寫一個無關緊要的DML語句
    }

}