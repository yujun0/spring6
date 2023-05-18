package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Bean的生命週期按照粗略的五步的話：
 * 第一步：實例化Bean（調用無參數構造方法。）
 * 第二步：給Bean屬性賦值（調用set方法。）
 * 第三步：初始化Bean（會調用Bean的init方法。注意：這個init方法需要自己寫，自己配。）
 * 第四步：使用Bean
 * 第五步：銷毀Bean（會調用Bean的destroy方法。注意：這個destroy方法需要自己寫，自己配。）
 **/
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String name;

    public User() {
        System.out.println("Step1:Execution of Parameterless Constructor Method.");
    }

    public void setName(String name) {
        System.out.println("Step2:Assign values to the properties of the object.");
        this.name = name;
    }

    // 這個方法需要自己寫，自己配。方法名隨意。
    public void initBean() {
        System.out.println("Step4:Initialize the Bean");
    }

    // 這個方法需要自己寫，自己配。方法名隨意。
    public void destroyBean() {
        System.out.println("Step7:Destroy the Bean.");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean這個類的加載器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生產這個Bean的工廠物件是：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("這個Bean的名字是：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Execution of InitializingBean's afterPropertiesSet.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Execution of DisposableBean's destroy Method.");
    }
}
