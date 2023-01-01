package com.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class AppConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    public DataSource dataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setDatabaseName("test");
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/test");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");
        return mysqlDataSource;
    }
}
