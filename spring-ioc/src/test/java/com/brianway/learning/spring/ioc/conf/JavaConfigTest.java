package com.brianway.learning.spring.ioc.conf;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/29.
 */
public class JavaConfigTest {

    /**
     * 通过构造函数加载配置类
     */
    @Test
    public void testStartDirectly() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);

        LogonService logonService = context.getBean(LogonService.class);
        logonService.printHelllo();
    }

    /**
     * 通过编码方式注册配置类
     */
    @Test
    public void testStartContainer() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //若在ServiceConfig类中通过@Import(DaoConfig.class)组装,则无需单独注册
        //context.register(DaoConfig.class);
        context.register(ServiceConfig.class);

        context.refresh();

        LogonService logonService = context.getBean(LogonService.class);
        logonService.printHelllo();
    }

    /**
     * 通过XML组装@Configuration配置类所提供的配置信息
     */
    @Test
    public void testConfigByXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/conf/beans-configuration.xml");
        LogonService logonService = context.getBean(LogonService.class);
        logonService.printHelllo();
    }

    /**
     * 通过@Configuration组装XML配置所提供的配置信息
     */
    @Test
    public void testConfigByConfiguration() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LogonAppConfig.class);
        LogonService logonService = context.getBean(LogonService.class);
        logonService.printHelllo();
    }

}
