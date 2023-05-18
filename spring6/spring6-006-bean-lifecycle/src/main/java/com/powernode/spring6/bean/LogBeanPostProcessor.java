package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 日誌Bean後處理器。
 **/
public class LogBeanPostProcessor implements BeanPostProcessor {

    // 方法有兩個參數：
    // 第一個參數：剛創建的Bean物件。
    // 第二個參數：Bean的名字。

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Step3：執行Bean後處理器的before方法。");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Step5：執行Bean後處理器的after方法。");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
