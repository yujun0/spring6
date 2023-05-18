package com.powernode.bank.service;

import com.powernode.bank.pojo.Account;

import java.util.List;

public interface AccountService {

    /**
     * 開戶
     */
    int save(Account act);

    /**
     * 銷毀
     */
    int deleteByActno(String actno);

    /**
     * 修改帳戶
     */
    int modify(Account account);

    /**
     * 查詢帳戶
     */
    Account getByActno(String actno);

    /**
     * 獲取所有帳戶
     */
    List<Account> getAll();

    /**
     * 轉帳
     */
    void transfer(String fromActno, String toActno, double moeny);

}