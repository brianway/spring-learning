package com.brianway.learning.spring.ioc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {
    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public LogDao logDao() {
        return new LogDao();
    }

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();
        logonService.setLogDao(logDao());
        logonService.setUserDao(userDao());
        return logonService;
    }
}
