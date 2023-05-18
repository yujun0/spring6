package com.powernode.bank.mapper;

import com.powernode.bank.pojo.Account;

import java.util.List;

public interface AccountMapper { // 該介面的實現類不需要寫，是mybatis通過動態代理機制生成的實現類。

    // 這就是DAO。只要編寫CRUD方法即可。

    /**
     * 新增帳戶
     *
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 根據帳號刪除帳戶
     *
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改帳戶
     *
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 根據帳號查詢帳戶
     *
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 查詢所有的帳戶
     *
     * @return
     */
    List<Account> selectAll();

}