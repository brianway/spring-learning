package com.brianway.learning.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class GreetingAfterAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnObj, Method method, Object[] args,
                               Object obj) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }
}
