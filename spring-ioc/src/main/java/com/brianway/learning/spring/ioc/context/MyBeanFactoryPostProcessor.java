package com.brianway.learning.spring.ioc.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by Brian on 2016/5/13.
 * 工厂后置处理器
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    //对car<bean>的brand属性配置信息进行“偷梁换柱”的加工操作
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("car");
        bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory()");
    }
}
