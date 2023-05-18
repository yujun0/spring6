package com.powernode.spring6.bean;

import java.util.Date;

public class Student {

    // java.util.Date 在Spring當中被當作簡單類型，但是簡單類型的話，注入的日期字符串格式有要求。
    // java.util.Date 在Spring當中中也可以被當作非簡單類型。
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
