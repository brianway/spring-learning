package com.brianway.learning.spring.ioc.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/6/7.
 * 测试bean的作用范围及生命过程方法
 */
public class AnnotationTest {
    @Test
    public void testBeanLife() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/annotation/beans-annotation.xml");
        ((ClassPathXmlApplicationContext) ctx).destroy();
    }

    @Test
    public void testService() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(LogonController.class);
        ctx.register(LogonService.class);
        ctx.register(LogDao.class);
        ctx.register(UserDao.class);

        ctx.refresh();
        LogonController controller = ctx.getBean(LogonController.class);
        controller.invokeInitMethod();
    }
}
