package com.powernode.spring6.test;

import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringJdbcTest {

    @Test
    public void testJdbc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }

    @Test
    public void testInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // insert語句
        String sql = "INSERT INTO t_user(real_name, age) VALUES (?,?)";
        // 注意：在JdbcTemplate當中，只要是insert delete update語句的，都是調用update方法。
        int count = jdbcTemplate.update(sql, "Vito", 7);
        System.out.println("count = " + count);
    }

    @Test
    public void testUpdate() {
        // 根據id來修改某一條記錄。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "UPDATE t_user SET real_name = ?, age = ? WHERE id = ?";
        int count = jdbcTemplate.update(sql, "Kobe", 55, 4);
        System.out.println(count);
    }

    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "DELETE FROM t_user WHERE id = ?";
        int count = jdbcTemplate.update(sql, 5);
        System.out.println(count);
    }

    @Test
    public void testQueryOne() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "SELECT id, real_name,age FROM t_user WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 3);
        System.out.println(user);
    }

    @Test
    public void testQueryAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "SELECT * FROM t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }

    @Test
    public void testQueryOneValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "SELECT count(1) FROM t_user"; // 返回總記錄條數是一個整數數字。
//        Long total = jdbcTemplate.queryForObject(sql, long.class);
        Integer total = jdbcTemplate.queryForObject(sql, int.class);
        System.out.println("總記錄條數：" + total);
    }


    @Test
    public void testBatchInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "INSERT INTO t_user(real_name, age) VALUES (?,?)";

        // 準備數據
        Object[] objs1 = {"Jun1", 20};
        Object[] objs2 = {"Jun2", 21};
        Object[] objs3 = {"Jun3", 22};
        Object[] objs4 = {"Jun4", 23};

        // 添加到List集合
        List<Object[]> list = List.of(objs1, objs2, objs3, objs4);

        // 執行SQL語句
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testBatchUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "UPDATE t_user SET real_name = ?, age = ? WHERE id = ?";

        // 準備數據
        Object[] objs1 = {"Jun", 30, 6};
        Object[] objs2 = {"Jun", 31, 7};
        Object[] objs3 = {"Jun", 32, 8};
        Object[] objs4 = {"Jun", 33, 9};

        // 添加到List集合
        List<Object[]> list = List.of(objs1, objs2, objs3, objs4);

        // 執行SQL語句
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }


    @Test
    public void testBatchDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "DELETE FROM t_user WHERE id = ?";
        // 準備數據
        Object[] objs1 = {6};
        Object[] objs2 = {7};
        Object[] objs3 = {8};
        Object[] objs4 = {9};
        // 添加到List集合
        List<Object[]> list = List.of(objs1, objs2, objs3, objs4);

        // 執行SQL語句
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testCallback() {
        // 如果你想寫JDBC代碼，可以使用callback回調函數。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 準備SQL語句
        String sql = "SELECT * from t_user WHERE id = ?";
        // 註冊回調函數，當execute方法執行的時候，回調函數中的doInPreparedStatement()會被調用。
        User user = jdbcTemplate.execute(sql, (PreparedStatementCallback<User>) ps -> {
            User user1 = null;
            ps.setInt(1, 2);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String realName = resultSet.getString("real_name");
                int age = resultSet.getInt("age");
                user1 = new User(id, realName, age);
            }
            return user1;
        });

        System.out.println(user);

    }
}
