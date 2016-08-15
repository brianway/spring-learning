package com.brianway.learning.spring.ioc.ditype;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/6/7.
 * 测试ditype包中的类的bean配置和加载情况
 */
public class DitypeTest {

    @Test
    public void listCars() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/ditype/beans-ditype.xml");
        int count = 7;
        Car[] cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = (Car) ctx.getBean("car" + (i > 0 ? i : ""));
            System.out.println(cars[i]);
        }
    }

    @Test
    public void listBosses() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/ditype/beans-ditype.xml");
        int count = 3;
        Boss[] bosses = new Boss[count];
        for (int i = 0; i < count; i++) {
            bosses[i] = (Boss) ctx.getBean("boss" + (i > 0 ? i : ""));
            System.out.println(bosses[i]);
        }
    }
}
