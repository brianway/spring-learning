package com.brianway.learning.spring.ioc.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by Brian on 2016/5/13.
 * 该类装载的Bean的xml配置文件:beanfactory/beans-BeanFactory.xml
 * 分别注册两个后处理器:MyBeanPostProcessor和MyInstantiationAwareBeanPostProcessor
 * (后处理器的实际调用顺序和注册顺序无关)
 */
public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory() {
        //装载配置文件并启动容器
        Resource res = new ClassPathResource("beanfactory/beans-BeanFactory.xml");
        BeanFactory bf = new XmlBeanFactory(res);

        //向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
        //向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //第一次从容器中获取car，将触发容器实例化该Bean,这将引发Bean生命周期方法调用
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //第二次从容器中获取car，直接从缓存池获取
        Car car2 = (Car) bf.getBean("car");

        System.out.println("car1==car2：" + (car1 == car2));
        //关闭容器
        ((XmlBeanFactory) bf).destroySingletons();
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}

/*
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
