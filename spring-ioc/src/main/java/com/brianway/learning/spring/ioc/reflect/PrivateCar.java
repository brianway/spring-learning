package com.brianway.learning.spring.ioc.reflect;

/**
 * Created by Brian on 2016/5/12.
 * 用来反射的类
 */
public class PrivateCar {
    private String color;

    protected void drive() {
        System.out.println("drive private car! the color is: " + color);
    }
}
