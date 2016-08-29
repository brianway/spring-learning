package com.brianway.learning.spring.ioc.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 引用 XML 配置信息
 */
@Configuration
@ImportResource("classpath:com/brianway/learning/spring/ioc/conf/beans-xmlconfig.xml")
public class LogonAppConfig {

    @Bean
    @Autowired
    public LogonService logonService(UserDao userDao, LogDao logDao) {
        LogonService logonService = new LogonService();
        logonService.setUserDao(userDao);
        logonService.setLogDao(logDao);
        return logonService;
    }
}
