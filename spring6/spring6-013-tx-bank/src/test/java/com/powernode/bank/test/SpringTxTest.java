package com.powernode.bank.test;

import com.powernode.bank.Spring6Config;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.impl.IsolationService1;
import com.powernode.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringTxTest {

    @Test
    public void testSpringTx() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("轉帳成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPropagation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 獲取1號service
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        // 3號帳戶
        Account act = new Account("act-004", 1000.0);
        accountService.save(act);
    }

    @Test
    public void testIsolation1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act-004");
    }

    @Test
    public void testIsolation2() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account act = new Account("act-004", 1000.0);
        i2.save(act);
    }

    @Test
    public void testNoXML() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("轉帳成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}