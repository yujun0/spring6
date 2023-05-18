package com.powernode.spring6.bean2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class A {
    public A() {
        System.out.println("A的無參數構造方法執行");
    }
}

@Controller
class B {
    public B() {
        System.out.println("B的無參數構造方法執行");
    }
}

@Service
class C {
    public C() {
        System.out.println("C的無參數構造方法執行");
    }
}

@Repository
class D {
    public D() {
        System.out.println("D的無參數構造方法執行");
    }
}

@Controller
class E {
    public E() {
        System.out.println("E的無參數構造方法執行");
    }
}