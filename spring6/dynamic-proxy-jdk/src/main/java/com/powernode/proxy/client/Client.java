package com.powernode.proxy.client;

import com.powernode.proxy.service.OrderService;
import com.powernode.proxy.service.OrderServiceImpl;
import com.powernode.proxy.service.TimerInvocationHandler;
import com.powernode.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

public class Client {
    //客戶端程序
    public static void main(String[] args) {
        // 創建目標物件
        OrderService target = new OrderServiceImpl();
        // 創建代理物件
        /*
          1. newProxyInstance 翻譯為：新建代理物件，也就是說調用這個方法可以創建代理物件。
             本質上，這個Proxy.newProxyInstance()的執行，做了兩件事：
             1. 在內存中的動態生成了一個代理類的字節碼class。
             2. new物件了，透過內存中生成的代理類代碼，實例化了代理物件。
          2. 關於newProxyInstance()方法的三個重要的參數，每一個什麼含義，有什麼用？
             1. ClassLoader loader
                類加載器。這個類加載器有什麼用呢？
                在內存當中生成的字節碼也是class文件，要執行也需要先加載到內存中，加載類就需要類加載器。
                所以這裡需要指定類加載器，並且JDK要求，目標類的類加載器必須和代理類的類加載器使用同一個。
             2. Class<?>[] interfaces
                代理類和目標類要實現同一個介面或同一些介面
                在內存中生成代理類的時候，這個代理類需要你告訴它實現哪些介面的。
             3. InvocationHandler h
                InvocationHandler 被翻譯為：調用處理器，是一個介面。
                在調用處理器介面中編寫的就是「增強代碼」
                因為具體要增強什麼代碼，JDK動態代理技術它是猜不到的，沒有那麼神。
                既然是介面，就要寫介面的實現類

                可能會有疑問？
                自己還要動手寫調用處理器介面的實現類，這不會類爆炸嗎？不會。
                因為這種調用處理器寫一次就好。

            注意：代理物件和目標物件實現的介面一樣，所以可以向下轉型。
         */
//        Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                               target.getClass().getInterfaces(),
//                               new TimerInvocationHandler(target));

        // 上面代碼通過一個工具類的封裝，就簡潔了。
        OrderService proxyObj = (OrderService) ProxyUtil.newProxyInstance(target);
        // 調用代理物件的代理方法
        // 注意：調用代理物件的代理方法的時候，如果你要做增強的話，目標物件的目標方法得保證執行。
        proxyObj.generate();
        proxyObj.modify();
        proxyObj.detail();

        String name = proxyObj.getName();
        System.out.println(name);
    }
}