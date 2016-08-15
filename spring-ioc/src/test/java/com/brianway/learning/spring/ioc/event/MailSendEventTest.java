package com.brianway.learning.spring.ioc.event;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brian on 16/6/23.
 */
public class MailSendEventTest {
    @Test
    public void testSendMail() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/brianway/learning/spring/ioc/event/beans-event.xml");
        MailSender mailSender = (MailSender) context.getBean("mailSender");
        mailSender.sendMail("weichuyang@163.com");
    }
}
