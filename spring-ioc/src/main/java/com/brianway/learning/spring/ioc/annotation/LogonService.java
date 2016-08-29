package com.brianway.learning.spring.ioc.annotation;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LogonService implements BeanNameAware {
    @Autowired(required = false)
    private LogDao logDao;
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public LogDao getLogDao() {
        return logDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setBeanName(String beanName) {
        System.out.println("beanName:" + beanName);
    }

    public void initMethod() {
        System.out.println("initMethod");
    }

}
