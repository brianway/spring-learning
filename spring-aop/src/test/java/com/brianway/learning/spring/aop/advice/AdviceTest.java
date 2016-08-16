package com.brianway.learning.spring.aop.advice;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/16.
 */
public class AdviceTest {
    @Test
    public void testBeforeAdviceWithCGLib() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        //spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        //设置代理目标
        pf.setTarget(target);
        //为代理目标添加增强
        pf.addAdvice(advice);
        //生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("Brian");
        proxy.serveTo("Way");
    }

    @Test
    public void testBeforeAdviceWithJDK() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        //spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        //指定对接口进行代理
        pf.setInterfaces(target.getClass().getInterfaces());
        //启用优化则还将使用Cglib2AopProxy代理
        //pf.setOptimize(true);
        //设置代理目标
        pf.setTarget(target);
        //为代理目标添加增强
        pf.addAdvice(advice);
        //生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("Brian");
        proxy.serveTo("Way");
    }

    @Test
    public void testAdviceConfiguredByXml() {
        String configPath = "com/brianway/learning/spring/aop/advice/beans-advice.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter-greetingAdvice");
        waiter.greetTo("Brian");
    }

    @Test
    public void testBeforeAndAfterAdvice() {
        String configPath = "com/brianway/learning/spring/aop/advice/beans-advice.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter-beforeAndAfter");
        waiter.greetTo("Brian");
    }

    @Test
    public void testAroundAdvice() {
        String configPath = "com/brianway/learning/spring/aop/advice/beans-advice.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter-around");
        waiter.greetTo("Brian");
    }

    @Test(expected = Exception.class)
    public void testThrowsAdvice() throws Exception {
        String configPath = "com/brianway/learning/spring/aop/advice/beans-advice.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService) context.getBean("forumService");
        forumService.updateForum(new Forum());
    }
}
