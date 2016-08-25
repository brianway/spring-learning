package com.brianway.learning.spring.ioc.attribute;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/6/7.
 * 测试注入参数
 */
public class AttributeTest {

    @Test
    public void referParent() {
        //父容器
        ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(new String[] {"com/brianway/learning/spring/ioc/attribute/beans-father.xml"});
        //指定pFacroty为该容器的父容器
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                new String[] {"com/brianway/learning/spring/ioc/attribute/beans-son.xml"},
                pFactory
        );
        Boss boss = (Boss) factory.getBean("boss");
        System.out.println(boss.getCar().toString());
    }

    @Test
    public void innerBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/attribute/beans-attribute.xml");
        Boss boss = (Boss) ctx.getBean("boss2");
        System.out.println(boss);
    }
}
