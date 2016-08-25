package com.brianway.learning.spring.ioc.beanfactory;

import org.junit.Test;

/**
 * Created by brian on 16/8/25.
 */
public class BeanLifeCycleTest {
    private String beanId = "car";

    @Test
    public void testSingleton() {
        String xmlPath = "com/brianway/learning/spring/ioc/beanfactory/beans-singleton.xml";
        BeanLifeCycle.lifeCycleInBeanFactory(xmlPath, beanId);
    }

    @Test
    public void testPrototype() {
        String xmlPath = "com/brianway/learning/spring/ioc/beanfactory/beans-prototype.xml";
        BeanLifeCycle.lifeCycleInBeanFactory(xmlPath, beanId);
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
第二次从容器中获取car
car1==car2：true
调用DisposableBean.destroy()
调用destroy-method指定的myDestroy()

 */


/*
------------testPrototype---------------

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
第二次从容器中获取car
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
car1==car2：false

 */