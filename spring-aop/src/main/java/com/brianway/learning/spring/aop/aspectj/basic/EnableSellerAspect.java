package com.brianway.learning.spring.aop.aspectj.basic;

import com.brianway.learning.spring.aop.aspectj.Seller;
import com.brianway.learning.spring.aop.aspectj.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by brian on 16/8/18.
 */
@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "com.brianway.learning.spring.aop.aspectj.NaiveWaiter", defaultImpl = SmartSeller.class)
    public Seller seller;
}
