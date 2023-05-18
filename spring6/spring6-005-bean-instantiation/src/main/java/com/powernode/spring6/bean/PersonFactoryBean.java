package com.powernode.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

public class PersonFactoryBean implements FactoryBean<Person> {
    // PersonFactoryBean也是一個Bean。只不過這個Bean比較特殊。叫做工廠Bean。
    // 通過工廠Bean這個特殊的Bean可以獲取一個普通的Bean。
    @Override
    public Person getObject() throws Exception {
        // 最終這個Bean的創建還是自己new的。
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    // 這個方法在介面中有默認實現。
    // 默認返回true，表示單例的。
    // 如果想多例，直接將這個方法修改為return false;即可。
    @Override
    public boolean isSingleton() {
        return true;
    }
}