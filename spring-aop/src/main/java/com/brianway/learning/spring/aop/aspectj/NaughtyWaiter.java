package com.brianway.learning.spring.aop.aspectj;

import com.brianway.learning.spring.aop.aspectj.anno.NeedTest;

public class NaughtyWaiter implements Waiter {
    @NeedTest
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter:greet to " + clientName + "...");
    }

    public void serveTo(String clientName) {
        System.out.println("NaughtyWaiter:serving " + clientName + "...");
    }

    public void joke(String clientName, int times) {
        System.out.println("NaughtyWaiter:play " + times + " jokes to " + clientName + "...");
    }
}
