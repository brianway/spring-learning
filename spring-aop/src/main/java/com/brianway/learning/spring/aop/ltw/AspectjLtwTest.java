package com.brianway.learning.spring.aop.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/22.
 *
 * VM options:
 * -javaagent:/path/to/spring-instrument-4.2.4.RELEASE.jar
 *
 * e.g.
 * `-javaagent:/Users/brian/.m2/repository/org/springframework/spring-instrument/4.2.4.RELEASE/spring-instrument-4.2.4.RELEASE.jar`
 */
public class AspectjLtwTest {
    public static void main(String[] args) {
        String configPath = "com/brianway/learning/spring/aop/ltw/beans-ltw.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = context.getBean(Waiter.class);
        waiter.greetTo("Brian");
        waiter.serveTo("Brian");
    }
}
