package com.brianway.learning.spring.aop.ltw;

public class Waiter {
    public void greetTo(String clientName) {
        System.out.println("Waiter:greet to " + clientName + "...");
    }

    public void serveTo(String clientName) {
        System.out.println("Waiter:serve to " + clientName + "...");
    }
}
