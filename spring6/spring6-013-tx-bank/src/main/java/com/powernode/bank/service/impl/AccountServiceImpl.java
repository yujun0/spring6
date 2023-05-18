package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    // 控制事務，因為在這個方法中要完成所有的轉帳業務。
    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {
        // 第一步：開啟事務

        // 第二步：執行核心業務邏輯
        // 查詢轉出賬戶的餘額是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("餘額不足!!!");
        }
        // 餘額充足
        Account toAct = accountDao.selectByActno(toActno);

        // 將內存中兩個物件的餘額先修改。
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        // 資料庫更新
        int count = accountDao.update(fromAct);
        // ====================================================
        // 模擬異常
        String s = null;
        s.toString();
        // ====================================================
        count += accountDao.update(toAct);

        if (count != 2) {
            throw new RuntimeException("轉帳失敗，請聯繫銀行！");
        }

        // 第三步：如果執行業務流程過程中，沒有異常。提交事務
        // 第四步：如果執行業務流程過程中，有異常，回滾事務。

//        withdraw();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void withdraw() {}

    @Resource(name = "accountService2")
    private AccountService accountService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(Account act) {
        // 這裡調用dao的insert方法。
        accountDao.insert(act); // 保存act-003帳戶

        // 創建帳戶物件
        Account act2 = new Account("act-004", 1000.0);
        try {
            accountService.save(act2); // 保存act-004帳戶
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 繼續往後進行當前自己service事務的事。
    }
}