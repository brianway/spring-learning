package com.brianway.learning.spring.aop.aspectj.advanced;

import com.brianway.learning.spring.aop.aspectj.Monitorable;
import com.brianway.learning.spring.aop.aspectj.Waiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect {
    /**
     * 复合运算
     */
//    @Before("!target(com.brianway.learning.spring.aop.aspectj.NaiveWaiter) "
//            + "&& execution(* serveTo(..)))")
//    public void notServeInNaiveWaiter() {
//        System.out.println("--notServeInNaiveWaiter() executed!--");
//    }
//
//    @After("within(com.brianway.learning.spring.aop.aspectj.*) "
//            + " && execution(* greetTo(..)))")
//    public void greeToFunction() {
//        System.out.println("--greeToFunction() executed!--");
//    }
//
//    @AfterReturning("target(com.brianway.learning.spring.aop.aspectj.Waiter) || " +
//            " target(com.brianway.learning.spring.aop.aspectj.Seller)")
//    public void waiterOrSeller() {
//        System.out.println("--waiterOrSeller() executed!--");
//    }

    /**
     * 引用命名切点
     */
//    @Before("TestNamePointcut.inPkgGreetTo()")
//    public void pkgGreetTo() {
//        System.out.println("--pkgGreetTo() executed!--");
//    }
//
//    @Before("!target(com.brianway.learning.spring.aop.aspectj.NaiveWaiter) && "
//            + "TestNamePointcut.inPkgGreetTo()")
//    public void pkgGreetToNotNaiveWaiter() {
//        System.out.println("--pkgGreetToNotNaiveWaiter() executed!--");
//    }

    /**
     * 访问连接点对象
     */
    @Around("execution(* greetTo(..)) && target(com.brianway.learning.spring.aop.aspectj.NaiveWaiter)")
    public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("------joinPointAccess-------");
        System.out.println("args[0]:" + pjp.getArgs()[0]);
        System.out.println("target:" + pjp.getTarget());
        System.out.println("signature:" + pjp.getSignature());
        System.out.println("this:" + pjp.getThis());

        pjp.proceed();
        System.out.println("-------joinPointAccess-------");
    }

    /**
     * 绑定
     */
    //------------绑定连接点参数----------//
    @Before("target(com.brianway.learning.spring.aop.aspectj.NaiveWaiter) && args(name,num,..)")
    public void bindJoinPointParams(int num, String name) {
        System.out.println("----bindJoinPointParams()----");
        System.out.println("name:" + name);
        System.out.println("num:" + num);
        System.out.println("----bindJoinPointParams()----");
    }

//  //------------绑定代理对象----------//
//	//@Before("execution(* greetTo(..)) && this(waiter)")
//	@Before("this(waiter)")
//	public void bindProxyObj(Waiter waiter){
//	   System.out.println("----bindProxyObj()----");
//	   System.out.println(waiter.getClass().getName());
//	   System.out.println("----bindProxyObj()----");
//	}

//  //------------绑定类注解对象----------//
//	@Before("@within(m)")
//	public void bindTypeAnnoObject(Monitorable m){
//	   System.out.println("----bindTypeAnnoObject()----");
//	   System.out.println(m.getClass().getName());
//	   System.out.println("----bindTypeAnnoObject()----");
//	}

//    //------------绑定抛出的异常----------//
//    @AfterReturning(value = "target(com.brianway.learning.spring.aop.aspectj.SmartSeller)", returning = "retVal")
//    public void bingReturnValue(int retVal) {
//        System.out.println("----bingReturnValue()----");
//        System.out.println("returnValue:" + retVal);
//        System.out.println("----bingReturnValue()----");
//    }

    //------------绑定抛出的异常----------//
    @AfterThrowing(value = "target(com.brianway.learning.spring.aop.aspectj.SmartSeller)", throwing = "iae")
    public void bindException(IllegalArgumentException iae) {
        System.out.println("----bindException()----");
        System.out.println("exception:" + iae.getMessage());
        System.out.println("----bindException()----");
    }
}
