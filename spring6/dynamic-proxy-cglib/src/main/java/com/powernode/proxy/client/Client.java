package com.powernode.proxy.client;

import com.powernode.proxy.service.TimerMethodInterceptor;
import com.powernode.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        // 創建字節碼增強器物件
        // 這個對像是CGLIB庫當中的核心物件，就是依靠它來生成代理類。
        Enhancer enhancer = new Enhancer();

        // 告訴CGLIB父類是誰，告訴CGLIB目標類是誰。
        enhancer.setSuperclass(UserService.class);

        // 設置回調(等同於JDK動態代理當中的調用處理器。InvocationHandler)
        // 在CGLIB當中不是InvocationHandler介面，是方法攔截器介面：MethodInterceptor
        enhancer.setCallback(new TimerMethodInterceptor());

        // 創建代理物件
        // 這一步會做兩件事：
        // 第一件事：在內存中生成UserService類的子類，其實就是代理類的字節碼。
        // 第二件事：創建代理物件。
        // 父類是UserService，子類這個代理類一定是UserService
        UserService userServiceProxy = (UserService) enhancer.create();

        // 建議大家能夠把CGLIB動態代理生成的代理物件的名字格式有點印象。
        // 根據這個名字可以推測框架底層是否使用了CGLIB動態代理
        // com.powernode.proxy.service.UserService$$EnhancerByCGLIB$$82cb55e3@6f79caec
        System.out.println(userServiceProxy);

        // 調用代理物件的代理方法。
        boolean success = userServiceProxy.login("admin", "123");
        System.out.println(success ? "登錄成功" : "登錄失敗");

        userServiceProxy.logout();
    }
}


// 底層本質
//class UserService$$EnhancerByCGLIB$$82cb55e3 extends UserService{}