package com.powernode.spring6.test;

import cn.powernode.Spring6Config;
import cn.powernode.service.StudentService;
import com.powernode.spring6.bean.*;
import com.powernode.spring6.bean3.MyDataSource;
import com.powernode.spring6.bean3.People;
import com.powernode.spring6.dao.OrderDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {

    @Test
    public void testBeanComponent() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
//        System.out.println(userBean);
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
//        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        // 如果你把整個value屬性全部省略了，bean默認名稱為類名首字母變小寫就是bean的名字
        Order orderBean = applicationContext.getBean("order", Order.class);
        System.out.println(orderBean);
//        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        Student studentBean = applicationContext.getBean("student", Student.class);
        System.out.println(studentBean);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        System.out.println(orderService);

        OrderDao orderDao = applicationContext.getBean("orderDao", OrderDao.class);
        System.out.println(orderDao);
    }

    @Test
    public void testChoose() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");
    }

    @Test
    public void testValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-injection.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }

    @Test
    public void testDIByAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
        People people = applicationContext.getBean("people", People.class);
        System.out.println(people);
    }

    @Test
    public void testAutowired() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        org.powernode.service.OrderService orderService = applicationContext.getBean("orderService", org.powernode.service.OrderService.class);
        orderService.generate();
    }

    @Test
    public void testResource() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }


    @Test
    public void testNoXML() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

}
