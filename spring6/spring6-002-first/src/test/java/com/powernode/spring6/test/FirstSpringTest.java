package com.powernode.spring6.test;

import com.powernode.spring6.bean.User;
import com.powernode.spring6.dao.UserDaoImplForMySQL;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {

    @Test
    public void testBeginInitBean() {
        // 注意：不是在調用getBean()方法的時候創建物件，執行以下代碼的時候，就會實例化物件，執行無參數構造方法。
        new ClassPathXmlApplicationContext("spring6.xml");

        // 你自己怎麼去使用log4j2記錄日誌信息呢？
        // 第一步：創建日誌記錄器物件
        // 獲取FirstSpringTest類的日誌記錄器物件，也就是說只要是FirstSpringTest類中的代碼執行記錄日誌的話，就輸出相關的日誌信息。
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

        // 第二步：記錄日誌，根據不同的級別來輸出日誌
        logger.info("我是一條消息");
        logger.debug("我是一條調適消息");
        logger.error("我是一條錯誤消息");
    }

    @Test
    public void testBeanFactory() {
        // ApplicationContext介面的超級父介面是：BeanFactory（翻譯為Bean工廠，就是能夠生產Bean物件的一個工廠物件。）
        // BeanFactory是IoC容器的頂級介面。
        // Spring的IoC容器底層實際上使用了：工廠模式。
        // Spring底層的IoC是怎麼實現的？ XML解析 + 工廠模式 + 反射機制
//         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }

    @Test
    public void testXmlPath() {
        // FileSystemXmlApplicationContext 不是從類路徑當中加載資源。
        // 這種方式很少用。了解即可。
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("d:/spring6.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }

    @Test
    public void testFistSpringCode() {
        // 第一步：獲取Spring容器物件。
        // ApplicationContext 翻譯為：應用。其實就是Spring容器。
        // ApplicationContext 是一個介面。
        // ApplicationContext 介面下有很多实實現類。其中有一個實現類叫做：ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext 專門從類路徑當中加載spring配置文件的一個Spring上下文物件。
        // 這行代碼只要執行：就相當於啟動了Spring容器，解析spring.xml文件，並且實例化所有的bean物件，放到spring容器當中。
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml", "beans.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml", "beans.xml", "xml/beans.xml");

        // 第二步：根據bean的id從Spring容器中獲取這個物件。
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

//        Object userDaoBean = applicationContext.getBean("userDaoBean");
        UserDaoImplForMySQL userDaoBean = applicationContext.getBean("userDaoBean", UserDaoImplForMySQL.class);
        System.out.println(userDaoBean);
        userDaoBean.insert();

        Object vipBean = applicationContext.getBean("vipBean");
        System.out.println(vipBean);

        Object userBean2 = applicationContext.getBean("userBean2");
        System.out.println(userBean2);

//         Object nowTime = applicationContext.getBean("nowTime");
//         Date nowTime = (Date) applicationContext.getBean("nowTime");
        // 不想強制類型轉換，可以使用以下代碼（通過第二個參數來指定返回的bean的類型。）
        Date nowTime = applicationContext.getBean("nowTime", Date.class);
        // 如果bean的id不存在，不會返回null，而是出現異常 -> NoSuchBeanDefinitionException
//         Object nowTime = applicationContext.getBean("nowTime2");
        System.out.println(nowTime);
        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strNowTime = sdf.format(nowTime);
        System.out.println(strNowTime);
    }
}
