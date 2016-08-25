package com.brianway.learning.spring.ioc.context;

import com.brianway.learning.spring.ioc.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Brian on 2016/5/12.
 * 通过带@Configuration的配置类启动容器
 */
public class AnnotationApplicationContext {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car", Car.class);
        car.introduce();
    }
}
