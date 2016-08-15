package com.brianway.learning.spring.ioc.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by brian on 16/6/23.
 * 实现ApplicationContextAware接口,从而拥有事件发布能力
 */
public class MailSender implements ApplicationContextAware {
    private ApplicationContext ctx;

    /**
     * ApplicationContextAware的接口方法,以便容器启动时注入容器实例
     *
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void sendMail(String to) {
        System.out.println("MailSender:模拟发送邮件");
        MailSendEvent mse = new MailSendEvent(this.ctx, to);
        //向容器中的所有事件监听器发送事件
        ctx.publishEvent(mse);

    }
}
