package com.brianway.learning.spring.ioc.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {

    @Autowired
    private DaoConfig daoConfig;

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();

        System.out.println(daoConfig.logDao() == daoConfig.logDao());
        logonService.setLogDao(daoConfig.logDao());
        logonService.setUserDao(daoConfig.userDao());
        return logonService;
    }
}
