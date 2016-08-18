package com.brianway.learning.spring.aop.aspectj.basic;

import com.brianway.learning.spring.aop.aspectj.Seller;
import com.brianway.learning.spring.aop.aspectj.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/18.
 */
public class DeclaredParentsTest {
    @Test
    public void test() {
        String configPath = "com/brianway/learning/spring/aop/aspectj/beans-basic.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = (Waiter) context.getBean("waiter");
        waiter.greetTo("Brian");

        Seller seller = (Seller) waiter;
        seller.sell("Beer", "Brian");

    }
}
