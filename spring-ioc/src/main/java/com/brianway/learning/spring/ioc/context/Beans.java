package com.brianway.learning.spring.ioc.context;

import com.brianway.learning.spring.ioc.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Brian on 2016/5/12.
 * 依带注解的java类提供配置信息
 */
//配置信息提供类
@Configuration
public class Beans {

    //定义一个Bean
    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("宝马");
        car.setMaxSpeed(100);
        return car;
    }

}
