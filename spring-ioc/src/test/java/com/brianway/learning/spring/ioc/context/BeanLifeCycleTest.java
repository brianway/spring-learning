package com.brianway.learning.spring.ioc.context;

import org.junit.Test;

/**
 * Created by brian on 16/8/25.
 */
public class BeanLifeCycleTest {
    private String beanId = "car";

    @Test
    public void testSingleton() {
        String xmlPath = "com/brianway/learning/spring/ioc/context/beans-singleton.xml";
        BeanLifeCycle.lifeCycleInApplicationContext(xmlPath, beanId);
    }

    @Test
    public void testPrototype() {
        String xmlPath = "com/brianway/learning/spring/ioc/context/beans-prototype.xml";
        BeanLifeCycle.lifeCycleInApplicationContext(xmlPath, beanId);
    }

}

/*
------------testSingleton---------------

调用BeanFactoryPostProcessor.postProcessBeanFactory()
调用Car()构造函数
调用setBrand()设置属性
调用BeanNameAware.setBeanName()
调用BeanFactoryAware.setBeanFactory()
调用ApplicationContextAware.setApplicationContext()
调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黄色
调用InitializingBean.afterPropertiesSet()
调用init-method指定的myInit()，将maxSpeed设置为240
调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为100
brand:奇瑞QQ;color:黄色;maxSpeed:100
第二次从容器中获取car
brand:奇瑞QQ;color:红色;maxSpeed:100
car1==car2：true

 */


/*
------------testPrototype---------------

调用BeanFactoryPostProcessor.postProcessBeanFactory()
调用Car()构造函数
调用setBrand()设置属性
调用BeanNameAware.setBeanName()
调用BeanFactoryAware.setBeanFactory()
调用ApplicationContextAware.setApplicationContext()
调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黄色
调用InitializingBean.afterPropertiesSet()
调用init-method指定的myInit()，将maxSpeed设置为240
调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为100
brand:奇瑞QQ;color:黄色;maxSpeed:100
第二次从容器中获取car
调用Car()构造函数
调用setBrand()设置属性
调用BeanNameAware.setBeanName()
调用BeanFactoryAware.setBeanFactory()
调用ApplicationContextAware.setApplicationContext()
调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黄色
调用InitializingBean.afterPropertiesSet()
调用init-method指定的myInit()，将maxSpeed设置为240
调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为100
brand:奇瑞QQ;color:黄色;maxSpeed:100
car1==car2：false

 */