package com.brianway.learning.spring.ioc.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Created by brian on 16/6/23.
 * 事件
 */
public class MailSendEvent extends ApplicationContextEvent {
    private String to;

    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {
        return this.to;
    }
}
