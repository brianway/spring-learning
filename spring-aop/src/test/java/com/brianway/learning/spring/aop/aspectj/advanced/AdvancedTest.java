package com.brianway.learning.spring.aop.aspectj.advanced;

import com.brianway.learning.spring.aop.aspectj.NaiveWaiter;
import com.brianway.learning.spring.aop.aspectj.SmartSeller;
import com.brianway.learning.spring.aop.aspectj.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/19.
 */
public class AdvancedTest {
    @Test
    public void testJoinPoint() {
        String configPath = "com/brianway/learning/spring/aop/aspectj/beans-advanced.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter) context.getBean("naiveWaiter");
        naiveWaiter.greetTo("Brian");
    }

    @Test
    public void testBindJoinPointArgs() {
        String configPath = "com/brianway/learning/spring/aop/aspectj/beans-advanced.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        NaiveWaiter naiveWaiter = (NaiveWaiter) context.getBean("naiveWaiter");
        naiveWaiter.smile("Brian", 2);
    }

    @Test(expected = Exception.class)
    public void testBindException() {
        String configPath = "com/brianway/learning/spring/aop/aspectj/beans-advanced.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        SmartSeller smartSeller = (SmartSeller) context.getBean("seller");
        //smartSeller.checkBill(2);
        smartSeller.checkBill(1);
    }
}
