package com.brianway.learning.spring.aop.aspectj.basic;

import com.brianway.learning.spring.aop.aspectj.anno.NeedTest;

@Monitorable
public class NaiveWaiter implements Waiter {
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter:greet to " + clientName + "...");
    }

    @NeedTest
    public void serveTo(String clientName) {
        System.out.println("NaiveWaiter:serving " + clientName + "...");
    }

    public void smile(String clientName, int times) {
        System.out.println("NaiveWaiter:smile to  " + clientName + times + "times...");
    }
}
