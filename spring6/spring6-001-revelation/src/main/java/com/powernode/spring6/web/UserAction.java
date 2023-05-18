package com.powernode.spring6.web;

import com.powernode.spring6.service.UserService;

/**
 * 表示層
 **/
public class UserAction {
    //private UserService userService = new UserServiceImpl();

    // 修改为
    private UserService userService;

    /**
     * 刪除用戶信息的請求
     */
    public void deleteRequest(){
        userService.deleteUser();
    }
}
