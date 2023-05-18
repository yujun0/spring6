package com.powernode.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration // 代替spring.xml配置文件，在這個類當中完成配置。
@ComponentScan("com.powernode.bank") // 組件掃描
@EnableTransactionManagement // 開啟事務註解
public class Spring6Config {

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {  //Spring在調用這個方法的時候會自動給我們傳遞過來一個dataSource物件
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    // Spring框架，看到這個@Bean註解後，會調用這個被標註的方法，這個方法的返回值是一個java物件，這個java物件會自動納入IoC容器管理。
    // 返回的物件就是Spring容器當中的一個Bean了。
    // 並且這個bean的名字是：dataSource
    @Bean(name = "dataSource")
    public DruidDataSource getDateSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring6");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
