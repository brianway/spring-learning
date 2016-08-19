package com.brianway.learning.spring.aop.aspectj;

public class WaiterManager {
    public void addWaiter(Waiter waiter) {
        System.out.println("add Waiter...");
    }

    public void addNaiveWaiter(NaiveWaiter nw) {
        System.out.println("add NaiveWaiter...");
    }

}
