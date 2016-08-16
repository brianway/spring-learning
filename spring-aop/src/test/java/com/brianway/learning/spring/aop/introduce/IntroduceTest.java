package com.brianway.learning.spring.aop.introduce;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/8/16.
 */
public class IntroduceTest {
    @Test
    public void testIntroduce() {
        String configPath = "com/brianway/learning/spring/aop/introduce/beans-introduce.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService) context.getBean("forumService");
        forumService.removeForum(10);
        forumService.removeTopic(1022);

        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }
}
