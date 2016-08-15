package com.brianway.learning.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
	public void before(Method method, Object[] args, Object obj) throws Throwable {
		String clientName = (String)args[0];
		System.out.println("How are you！Mr."+clientName+".");
	}
}
