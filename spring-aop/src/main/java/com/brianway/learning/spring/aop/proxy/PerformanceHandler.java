package com.brianway.learning.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by brian on 16/6/24.
 * 横切代码的安置处
 */
public class PerformanceHandler implements InvocationHandler {
    /**
     * 目标的业务类
     */
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        //通过反射调用业务类的目标方法
        Object object = method.invoke(target, args);
        PerformanceMonitor.end();
        return object;
    }
}
