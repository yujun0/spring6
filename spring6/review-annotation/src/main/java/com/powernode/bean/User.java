package com.powernode.bean;

import com.powernode.annotation.Component;

//@Component(屬性名 = 屬性值, 屬性名 = 屬性值, 屬性名 = 屬性值....)
//@Component(value = "userBean")
// 如果屬性名是value，value可以省略。
@Component("usrBean")
public class User {

    // 編譯器報錯，不能出現在這裡。
    //@Component(value = "test")
    //private String name;
}