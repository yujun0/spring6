package com.powernode.reflect;

public class SomeService {
    public void doSome() {
        System.out.println("public void doSome()執行。");
    }

    public String doSome(String s) {
        System.out.printf("public String doSome(String %s)執行。\n", s);
        return s;
    }

    public String doSome(String s, int i) {
        System.out.printf("public String doSome(String %s, int %d)執行。\n", s, i);
        return String.format("%s %d", s, i);
    }
}
