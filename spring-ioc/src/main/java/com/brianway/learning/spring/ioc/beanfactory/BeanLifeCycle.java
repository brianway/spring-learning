package com.brianway.learning.spring.ioc.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by Brian on 2016/5/13.
 * 该类装载的Bean的xml配置文件:com/brianway/learning/spring/ioc/beanfactory/beans-singleton.xml
 * 分别注册两个后处理器:MyBeanPostProcessor 和 MyInstantiationAwareBeanPostProcessor
 * (后处理器的实际调用顺序和注册顺序无关)
 */
public class BeanLifeCycle {
    public static void lifeCycleInBeanFactory(String xmlPath, String beanId) {
        //装载配置文件并启动容器
        Resource res = new ClassPathResource(xmlPath);
        BeanFactory bf = new XmlBeanFactory(res);

        //向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
        //向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //第一次从容器中获取car，将触发容器实例化该Bean,这将引发Bean生命周期方法调用
        Car car1 = (Car) bf.getBean(beanId);
        car1.introduce();
        car1.setColor("红色");

        System.out.println("第二次从容器中获取car");
        //第二次从容器中获取car，若为 singleton,直接从缓存池获取
        Car car2 = (Car) bf.getBean(beanId);

        System.out.println("car1==car2：" + (car1 == car2));
        //关闭容器
        ((XmlBeanFactory) bf).destroySingletons();
    }

}


