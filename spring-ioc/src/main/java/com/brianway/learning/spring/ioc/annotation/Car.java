package com.brianway.learning.spring.ioc.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 基于注解的Car类
 */
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Scope("prototype")
@Component
public class Car {
    private int maxSpeed;
    public String brand;
    private double price;

    public static String HONG_QI = "红旗";

    //--------get和set方法----------
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "brand:" + brand + "/maxSpeed:" + maxSpeed + "/price:" + price;
    }

}
