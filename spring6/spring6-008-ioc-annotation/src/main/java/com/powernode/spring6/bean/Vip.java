package com.powernode.spring6.bean;

import org.springframework.stereotype.Controller;

@Controller("vipBean") // 如果屬性名是value的話，這個屬性名可以省略。
public class Vip {
}

/*
以上的這個註解@Controller("vipBean")就相當於以下的這個配置信息：
<bean id="vipBean" class="com.powernode.spring6.bean.Vip"></bean>
 */