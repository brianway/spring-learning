package com.brianway.learning.spring.ioc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DaoConfig {

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Scope("prototype")
    @Bean
    public LogDao logDao() {
        return new LogDao();
    }
}
