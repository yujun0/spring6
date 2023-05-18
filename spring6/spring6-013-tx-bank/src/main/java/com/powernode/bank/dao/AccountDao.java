package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * 專門負責帳戶信息的CRUD操作。
 * DAO中只執行SQL語句，沒有任何業務邏輯。
 * 也就是說DAO不和業務掛鉤。
 **/
public interface AccountDao {

    /**
     * 根據帳號查詢帳戶信息
     */
    Account selectByActno(String actno);

    /**
     * 更新帳戶信息。
     */
    int update(Account act);

    /**
     * 保存帳戶信息
     */
    int insert(Account act);

}