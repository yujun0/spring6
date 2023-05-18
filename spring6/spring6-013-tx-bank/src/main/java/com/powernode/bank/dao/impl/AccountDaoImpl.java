package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "SELECT * FROM t_act WHERE actno = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
    }

    @Override
    public int update(Account act) {
        String sql = "UPDATE t_act SET balance = ? WHERE actno = ?";
        return jdbcTemplate.update(sql, act.getBalance(), act.getActno());
    }

    @Override
    public int insert(Account act) {
        String sql = "INSERT INTO t_act VALUES (?,?)";
        return jdbcTemplate.update(sql, act.getActno(), act.getBalance());
    }

}
