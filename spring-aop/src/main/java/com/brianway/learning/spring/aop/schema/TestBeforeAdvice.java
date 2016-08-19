package com.brianway.learning.spring.aop.schema;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class TestBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("------TestBeforeAdvice------");
        System.out.println("clientName:" + args[0]);
        System.out.println("------TestBeforeAdvice------");
    }
}
