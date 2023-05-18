package com.powernode.spring6.biz;

import org.springframework.stereotype.Service;

@Service
public class VipService {

    public void saveVip() {
        System.out.println("新增會員信息");
    }

    public void deleteVip() {
        System.out.println("刪除會員信息");
    }

    public void modifyVip() {
        System.out.println("修改會員信息");
    }

    public void getVip() {
        System.out.println("獲取會員信息");
    }
}