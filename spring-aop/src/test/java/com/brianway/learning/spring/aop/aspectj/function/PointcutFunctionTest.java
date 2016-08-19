package com.brianway.learning.spring.aop.aspectj.function;

import com.brianway.learning.spring.aop.aspectj.NaiveWaiter;
import com.brianway.learning.spring.aop.aspectj.Seller;
import com.brianway.learning.spring.aop.aspectj.Waiter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/18.
 */
public class PointcutFunctionTest {
    @Test
    public void test() {
        String configPath = "com/brianway/learning/spring/aop/aspectj/beans-function.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter) context.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) context.getBean("naughtyWaiter");

        naiveWaiter.greetTo("Brian");
        naughtyWaiter.greetTo("Way");
    }

    @Test
    public void testThis() {
        String configPath = "com/brianway/learning/spring/aop/aspectj/beans-function.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter) context.getBean("naiveWaiter");

        naiveWaiter.greetTo("Brian");
        naiveWaiter.serveTo("Brian");
        //TODO 为什么这里sell后没调用 thisTest()?
        ((Seller) naiveWaiter).sell("Beer", "Brian");

        Assert.assertEquals("is NaiveWaiter? ", false, (naiveWaiter instanceof NaiveWaiter));
        // true if  <aop:aspectj-autoproxy proxy-target-class="true"/>
        // Assert.assertEquals("is NaiveWaiter? ", true, (naiveWaiter instanceof NaiveWaiter));
        Assert.assertEquals("is Waiter? ", true, (naiveWaiter instanceof Waiter));
        Assert.assertEquals("is Seller? ", true, (naiveWaiter instanceof Seller));
    }

}
