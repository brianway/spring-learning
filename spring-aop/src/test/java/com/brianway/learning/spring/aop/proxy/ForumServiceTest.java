package com.brianway.learning.spring.aop.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by brian on 16/6/24.
 */
public class ForumServiceTest {
    /**
     * 测试拥有监控能力的ForumServiceImplWithMonitor业务方法
     */
    @Test
    public void testWithMonitor() {
        ForumService forumService = new ForumServiceImplWithMonitor();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }

    /**
     * 测试使用JDK动态代理实现的AOP
     */
    @Test
    public void testWithJDK() {
        //希望被代理的目标业务类
        ForumService target = new ForumServiceImpl();

        //将目标业务类和横切代码编织在一起
        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler
        );

        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }

    /**
     * 测试使用CGLib动态代理实现的AOP
     */
    @Test
    public void testWithCGLib() {
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
