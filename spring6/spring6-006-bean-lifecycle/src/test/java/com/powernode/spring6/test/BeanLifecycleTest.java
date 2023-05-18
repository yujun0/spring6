package com.powernode.spring6.test;

import com.powernode.spring6.bean.Student;
import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

    /**
     * Spring容器只對singleton的Bean進行完整的生命週期管理。
     * 如果是prototype作用域的Bean，Spring容器只負責將該Bean初始化完畢。等客戶端程序一旦獲取到該Bean之後，Spring容器就不再管理該物件的生命週期了。
     */
    @Test
    public void testBeanLifecycleFive() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("Step6：使用Bean：" + user);

        // 注意：必須手動關閉Spring容器，這樣Spring容器才會銷毀Bean.
        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
        classPathXmlApplicationContext.close();
    }

    @Test
    public void testRegisterBean() {
        // 自己new的物件
        Student student = new Student();
        System.out.println(student);

        // 將以上自己new的這個物件納入Spring容器來管理。半路上交給Spring來管理。
        // 創建 默認可列表 BeanFactory 物件
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 註冊Bean
        factory.registerSingleton("studentBean", student);

        // 從spring容器中獲取Bean
        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }

}
