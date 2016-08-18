package com.brianway.learning.spring.aop.autoproxy;

import com.brianway.learning.spring.aop.advisor.Seller;
import com.brianway.learning.spring.aop.advisor.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/18.
 */
public class AutoProxyCreatorTest {
    @Test
    public void testBeanNameAutoProxyCreator() {
        String configPath = "com/brianway/learning/spring/aop/autoproxy/beans-beanname.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter");
        Seller seller = (Seller) context.getBean("seller");
        waiter.greetTo("Brian");
        seller.greetTo("Brian");
    }

    @Test
    public void testDefaultAdvisorAutoProxyCreator() {
        String configPath = "com/brianway/learning/spring/aop/autoproxy/beans-defaultadvisor.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) context.getBean("waiter");
        Seller seller = (Seller) context.getBean("seller");
        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
        seller.greetTo("Brian");
    }

}
