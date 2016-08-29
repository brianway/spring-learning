package com.brianway.learning.spring.ioc.factorybean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/29.
 */
public class CarFactoryBeanTest {
    @Test
    public void testGetBean() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/factorybean/beans-factorybean.xml");
        Car carFactoryBean1 = (Car) ctx.getBean("car-factorybean");
        Car carFactoryBean2 = (Car) ctx.getBean("car-factorybean");

        //isSingleton() return false
        Assert.assertFalse(carFactoryBean1 == carFactoryBean2);
        System.out.println(carFactoryBean1);
    }

    @Test
    public void testGetCar() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/factorybean/beans-factorybean.xml");
        Car car1 = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean("car");

        System.out.println(car1);
        Assert.assertTrue(car1 == car2);
    }

    @Test
    public void testGetFactory() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/factorybean/beans-factorybean.xml");
        //获取 CarFactoryBean 自身实例, beanName 前加 &
        Object factory = ctx.getBean("&car-factorybean");

        Assert.assertTrue(CarFactoryBean.class == factory.getClass());
        Assert.assertEquals(CarFactoryBean.class, factory.getClass());
        System.out.println(factory.getClass());
    }

}
