package com.brianway.learning.spring.aop.schema;

import com.brianway.learning.spring.aop.aspectj.NaiveWaiter;
import com.brianway.learning.spring.aop.aspectj.Seller;
import com.brianway.learning.spring.aop.aspectj.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/19.
 */
public class SchemaTest {
    @Test
    public void testSimple() {
        String configPath = "com/brianway/learning/spring/aop/schema/beans-schema.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter) context.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) context.getBean("naughtyWaiter");
        naiveWaiter.greetTo("Brian");
        naughtyWaiter.greetTo("Brian");
    }

    @Test
    public void testIntroduce() {
        String configPath = "com/brianway/learning/spring/aop/schema/beans-schema.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter) context.getBean("naiveWaiter");
        ((Seller) naiveWaiter).sell("Beer", "Brian");
    }

    @Test
    public void testBindParams() {
        String configPath = "com/brianway/learning/spring/aop/schema/beans-schema.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter) context.getBean("naiveWaiter");
        ((NaiveWaiter) naiveWaiter).smile("Brian", 2);
    }
}
