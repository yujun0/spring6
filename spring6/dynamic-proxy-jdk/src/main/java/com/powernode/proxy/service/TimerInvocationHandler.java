package com.powernode.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 專門負責計時的一個調用處理器物件。
 * 在這個調用處理器當中編寫計時相關的增強代碼。
 * 這個調用處理器只需要寫一個就行了。
 **/
public class TimerInvocationHandler implements InvocationHandler {
    // 目標物件
    private final Object target;

    public TimerInvocationHandler(Object target) {
        // 賦值給成員變量
        this.target = target;
    }

    /*
       1. 為什麼強行要求你必須實現InvocationHandler介面？
          因為一個類實現介面就必須實現介面中的方法。
          以下這個方法必須是invoke()，因為JDK在底層調用invoke()方法的程序已經提前寫好了。
          注意：invoke方法不是我們負責調用的，是JDK負責調用的。

       2. invoke方法什麼時候被調用呢？
          當代理物件調用代理方法的時候，註冊在InvocationHandler調用處理器當中的invoke()方法被調用。

       3. invoke方法的三個參數：
            invoke方法是JDK負責調用的，所以JDK調用這個方法的時候會自動給我們傳過來這三個參數。
            我們可以在invoke方法的大括號中直接使用。
            1. Object proxy  代理物件的引用，這個參數使用較少。
            2. Method method 目標物件上的目標方法，要執行的目標方法就是它
            3. Object[] args 目標方法上的實參。

            invoke方法執行過程中，使用method來調用目標物件的目標方法。
         */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 這個介面的目的就是為了讓你有地方寫增強代碼。
        //System.out.println("增強1");
        long begin = System.currentTimeMillis();

        // 調用目標物件上的目標方法
        // 方法四要素：哪個物件，哪個方法，傳什麼參數，返回什麼值。
        Object returnValue = method.invoke(target, args);

        //System.out.println("增強2");
        long end = System.currentTimeMillis();
        System.out.println("耗時" + (end - begin) + "毫秒");

        // 注意這個invoke方法的返回值，如果代理物件調用代理方法之後，需要返回結果的話，invoke方法必須將目標物件的目標方法執行結果繼續返回。
        return returnValue;
    }
}