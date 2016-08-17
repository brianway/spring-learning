package com.brianway.learning.spring.aop.advisor;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingOnlyDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    /**
     * 对方法进行动态切点检查
     */
    public boolean matches(Method method, Class clazz, Object[] args) {
        System.out.println("调用matches(method,clazz)对" + clazz.getName() + "." + method.getName() + "做动态检查.");
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }

}
