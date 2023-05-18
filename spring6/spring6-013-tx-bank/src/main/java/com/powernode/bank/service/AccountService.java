package com.powernode.bank.service;

import com.powernode.bank.pojo.Account;

/**
 * 業務介面
 * 事務就是在這個介面下控制的
 **/
public interface AccountService {

    /**
     * 轉帳業務方法
     * @param fromActno 從這個帳戶轉出
     * @param toActno 轉入這個帳戶
     * @param money 轉帳金額
     */
    void transfer(String fromActno, String toActno, double money);

    /**
     * 保存帳戶信息。
     * @param act
     */
    void save(Account act);

}