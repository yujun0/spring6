package com.powernode.spring6.test;

import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJUnit4Test {

    @Autowired
    private User user;

    @Test
    public void testUser() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.getName());
    }

    @Test
    public void testUser2() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.getName());
    }

    @Test
    public void testUser3() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.getName());
    }

}
