package com.brianway.learning.spring.ioc.example;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Brian on 2016/5/12.
 * IOC示例测试
 */
public class MoAttackTest {

    @Test
    public void show() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("example/beans-example.xml");
        MoAttack moAttack = (MoAttack) ctx.getBean("moAttack");
        moAttack.cityGateAsk();

    }
}
