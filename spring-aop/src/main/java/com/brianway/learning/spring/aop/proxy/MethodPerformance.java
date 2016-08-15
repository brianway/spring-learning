package com.brianway.learning.spring.aop.proxy;

/**
 * Created by brian on 16/6/24.
 * 记录性能监视信息
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        //记录目标类方法开始执行点的时间
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        //获取目标类方法执行完成后的系统时间
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod + "花费" + elapse + "毫秒");
    }

}
