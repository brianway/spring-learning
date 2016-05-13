package com.brianway.learning.spring.ioc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Brian on 2016/5/12.
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.brianway.learning.spring.ioc.reflect.PrivateCar");
        PrivateCar privateCar =(PrivateCar)clazz.newInstance();

        Field colorFld = clazz.getDeclaredField("color");
        colorFld.setAccessible(true);
        colorFld.set(privateCar,"红色");

        Method driveMtd = clazz.getDeclaredMethod("drive");
        driveMtd.setAccessible(true);
        driveMtd.invoke(privateCar);

    }
}
