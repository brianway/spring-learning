package com.brianway.learning.spring.aop.aspectj.example;

import com.brianway.learning.spring.aop.advice.NaiveWaiter;
import com.brianway.learning.spring.aop.advice.Waiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/18.
 */
public class AspectJProxyTest {
    @Test
    public void testAspectJProxyFactory() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);

        Waiter proxy = factory.getProxy();
        proxy.greetTo("Brian");
        proxy.serveTo("Brian");
    }

    @Test
    public void testXmlAutoProxy() {
        String configPath = "com/brianway/learning/spring/aop/aspectj/beans-example.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter");

        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
    }

}
