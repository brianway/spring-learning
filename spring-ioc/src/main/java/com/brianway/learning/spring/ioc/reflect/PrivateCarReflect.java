package com.brianway.learning.spring.ioc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Brian on 2016/5/12.
 * 测试java反射机制
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.brianway.learning.spring.ioc.reflect.PrivateCar");
        PrivateCar privateCar = (PrivateCar) clazz.newInstance();

        Field colorFld = clazz.getDeclaredField("color");
        //取消语言检查访问private方法
        colorFld.setAccessible(true);
        colorFld.set(privateCar, "红色");

        Method driveMtd = clazz.getDeclaredMethod("drive");
        //取消语言检查访问protected方法
        driveMtd.setAccessible(true);
        driveMtd.invoke(privateCar);
    }
}
