package com.brianway.learning.spring.aop.aspectj;

import com.brianway.learning.spring.aop.aspectj.anno.NeedTest;

public interface Waiter {
    @NeedTest
    void greetTo(String clientName);

    void serveTo(String clientName);
}
