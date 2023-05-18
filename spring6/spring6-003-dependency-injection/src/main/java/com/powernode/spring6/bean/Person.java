package com.powernode.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

    // 注入List集合
    private List<String> names;

    // 注入Set集合
    private Set<String> addrs;

    // 注入Map集合
    // 多個電話
    private Map<Integer, String> phones;

    // 注入屬性類物件
    // Properties本質上也是一個Map集合。
    // Properties的父類Hashtable，Hashtable實現了Map接口。
    // 雖然這個也是一個Map集合，但是和Map的注入方式有點像，但是不同。
    // Properties的key和value只能是String類型。
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

    @Override
    public String toString() {
        return "Person{" +
               "names=" + names +
               ", addrs=" + addrs +
               ", phones=" + phones +
               ", properties=" + properties +
               '}';
    }
}
