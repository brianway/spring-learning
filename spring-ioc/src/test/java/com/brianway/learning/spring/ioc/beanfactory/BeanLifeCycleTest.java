package com.brianway.learning.spring.ioc.beanfactory;

import com.brianway.learning.spring.ioc.reflect.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/25.
 */
public class BeanLifeCycleTest {
    @Test
    public void testSingleton() {
        String beanId = "car-singleton";
        BeanLifeCycle.lifeCycleInBeanFactory(beanId);
    }

    @Test
    public void testPrototype() {
        String beanId = "car-prototype";
        BeanLifeCycle.lifeCycleInBeanFactory(beanId);
    }

    @Test
    public void testApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanfactory/beans-ApplicationContext.xml");
        Car car = (Car)context.getBean("car");
        car.introduce();
    }

}

/*
------------testSingleton---------------
#log4j.rootLogger=DEBUG, stdout
log4j.rootLogger=INFO, stdout
输出：
InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation
调用Car()构造函数
InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation
InstantiationAwareBeanPostProcessor.postProcessPropertyValues
调用setBrand()设置属性
调用BeanNameAware.setBeanName()
调用BeanFactoryAware.setBeanFactory()
调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色
调用InitializingBean.afterPropertiesSet()
调用init-method指定的myInit()，将maxSpeed设置为240
调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200
brand:红旗CA72;color:黑色;maxSpeed:200
car1==car2：true
调用DisposableBean.destroy()
调用destroy-method指定的myDestroy()
 */


/*
------------testPrototype---------------
调用Car()构造函数
调用setBrand()设置属性
调用BeanNameAware.setBeanName()
调用BeanFactoryAware.setBeanFactory()
调用InitializingBean.afterPropertiesSet()
调用init-method指定的myInit()，将maxSpeed设置为240
brand:红旗CA72;color:null;maxSpeed:240
调用Car()构造函数
调用setBrand()设置属性
调用BeanNameAware.setBeanName()
调用BeanFactoryAware.setBeanFactory()
调用InitializingBean.afterPropertiesSet()
调用init-method指定的myInit()，将maxSpeed设置为240
car1==car2：false
 */