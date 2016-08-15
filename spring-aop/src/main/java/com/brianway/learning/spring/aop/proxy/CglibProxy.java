package com.brianway.learning.spring.aop.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by brian on 16/6/24.
 * 采用CGLib,代理创建器
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);//设置需要创建子类的类
        enhancer.setCallback(this);
        return enhancer.create();//通过字节码技术动态创建子类实例
    }

    /**
     * 拦截父类所有方法的调用
     *
     * @param o 目标类的实例
     * @param method 目标类方法的反射对象
     * @param args 方法的动态入参
     * @param methodProxy 代理类对象
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(o, args);//通过代理类调用父类中的方法
        PerformanceMonitor.end();
        return result;
    }
}
