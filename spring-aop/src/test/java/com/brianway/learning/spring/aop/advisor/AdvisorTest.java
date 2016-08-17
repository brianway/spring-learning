package com.brianway.learning.spring.aop.advisor;

import com.brianway.learning.spring.aop.introduce.ForumService;
import com.brianway.learning.spring.aop.introduce.Monitorable;
import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/17.
 */
public class AdvisorTest {
    @Test
    public void testAdvisor() {
        String configPath = "com/brianway/learning/spring/aop/advisor/beans-advisor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter");
        Seller seller = (Seller) context.getBean("seller");
        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
        seller.greetTo("Brian");
    }

    @Test
    public void testRegexpAdvisor() {
        String configPath = "com/brianway/learning/spring/aop/advisor/beans-advisor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter-regexp");
        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
    }

    @Test
    public void testDynamicAdvisor() {
        String configPath = "com/brianway/learning/spring/aop/advisor/beans-advisor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter-dynamic");

        System.out.println("-------begin to invoke method----------");
        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
        //special client
        waiter.greetTo("John");
        waiter.serveTo("john");
    }

    @Test
    public void testOnlyDynamicAdvisor() {
        Waiter target = new Waiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        Pointcut pointcut = new GreetingOnlyDynamicPointcut();

        advisor.setPointcut(pointcut);
        advisor.setAdvice(advice);
        //spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        //生成代理实例
        Waiter waiter = (Waiter) pf.getProxy();

        System.out.println("-------begin to invoke method----------");
        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
        //special client
        waiter.greetTo("John");
        waiter.serveTo("john");
    }

    @Test
    public void testControlFlowAdvisor() {
        String configPath = "com/brianway/learning/spring/aop/advisor/beans-advisor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter-controlFlow");

        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);

        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
        wd.service("Brian");
    }

    @Test
    public void testComposableAdvisor() {
        String configPath = "com/brianway/learning/spring/aop/advisor/beans-advisor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter-composable");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);

        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
        wd.service("Brian");
    }

    @Test
    public void testIntroduceAdvisor() {
        String configPath = "com/brianway/learning/spring/aop/advisor/beans-advisor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService) context.getBean("forumService");

        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }

}
