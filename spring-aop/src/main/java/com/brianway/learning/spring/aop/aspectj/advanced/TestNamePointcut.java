package com.brianway.learning.spring.aop.aspectj.advanced;

import org.aspectj.lang.annotation.Pointcut;

public class TestNamePointcut {
    @Pointcut("within(com.brianway.learning.spring.aop.aspectj.*)")
    private void inPackage() {
    }

    @Pointcut("execution(* greetTo(..)))")
    protected void greetTo() {
    }

    @Pointcut("inPackage() and greetTo()")
    public void inPkgGreetTo() {
    }
}
