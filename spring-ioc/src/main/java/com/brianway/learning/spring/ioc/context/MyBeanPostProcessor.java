package com.brianway.learning.spring.ioc.context;

import com.brianway.learning.spring.ioc.beanfactory.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Brian on 2016/5/13.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黄色");
                car.setColor("黄色");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为100");
                car.setMaxSpeed(100);
            }
        }
        return bean;
    }
}
