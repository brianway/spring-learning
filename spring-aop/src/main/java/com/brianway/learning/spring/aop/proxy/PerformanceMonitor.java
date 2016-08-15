package com.brianway.learning.spring.aop.proxy;

/**
 * Created by brian on 16/6/24.
 * 性能监视的实现类
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();

    /**
     * 启动对某一目标方法的性能监视
     */
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecord.get();

        //打印性能监视结果
        mp.printPerformance();
    }
}
