package cn.powernode.dao.impl;

import cn.powernode.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImplForOracle implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle正在刪除student....");
    }
}
