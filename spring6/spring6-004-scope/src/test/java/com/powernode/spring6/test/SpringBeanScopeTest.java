package com.powernode.spring6.test;

import com.powernode.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {

    @Test
    public void testThreadScope() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);

        // 啟動一個新的線程
        new Thread(() -> {
            SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
            System.out.println(sb2);
            SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
            System.out.println(sb3);
        }).start();
    }

    @Test
    public void testBeanScope() {
        /**
         * 1. Spring默認情況下是如何管理這個Bean的：
         *      默認情況下Bean是單例的。 (單例：singleton)
         *      在Spring上下文初始化的時候實例化。
         *      每一次調用getBean()方法的時候，都返回那個單例的物件。
         *
         * 2. 當將bean的scope屬性設置為prototype：
         *      bean是多例的。
         *      spring上下文初始化的時候，並不會初始化這些prototype的bean。
         *      每一次調用getBean()方法的時候，實例化該bean物件。
         *      prototype翻譯為：原型。
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
//        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
//        System.out.println(sb);
//
//        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
//        System.out.println(sb2);
//
//        SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
//        System.out.println(sb3);
    }


}
