package com.powernode.spring6.bean;

import org.springframework.stereotype.Service;

@Service // 如果你把整個value屬性全部省略了，bean有沒有默認的名稱？有：類名首字母變小寫就是bean的名字。
public class Order {
}

/*

以上的這個註解@Service就相當於以下的這個配置信息：
<bean id="order" class="com.powernode.spring6.bean.Order"></bean>

*/