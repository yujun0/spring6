package cn.powernode;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 編寫一個類，代替Spring框架的配置文件。
 **/
@Configuration
@ComponentScan({"cn.powernode.dao", "cn.powernode.service"})
public class Spring6Config {
}
