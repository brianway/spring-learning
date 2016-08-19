package com.brianway.learning.spring.aop.aspectj.function;

import com.brianway.learning.spring.aop.aspectj.Seller;
import com.brianway.learning.spring.aop.aspectj.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "com.brianway.learning.spring.aop.aspectj.NaiveWaiter", defaultImpl = SmartSeller.class)
    public static Seller seller;

}
