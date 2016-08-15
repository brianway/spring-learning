package com.brianway.learning.spring.aop.proxy;

/**
 * Created by brian on 16/6/24.
 */
public class ForumServiceImplWithMonitor implements ForumService {
    public void removeTopic(int topicId) {
        //开始对方法进行性能监控
        PerformanceMonitor.begin("com.brianway.learning.spring.aop.proxy.ForumServiceImplWithMonitor.removeTopic");
        System.out.println("模拟删除Topic记录" + topicId);

        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //结束对该方法性能监控
        PerformanceMonitor.end();

    }

    public void removeForum(int forumId) {
        //开始对方法进行性能监控
        PerformanceMonitor.begin("com.brianway.learning.spring.aop.proxy.ForumServiceImplWithMonitor.removeForum");
        System.out.println("模拟删除Topic记录" + forumId);

        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //结束对该方法性能监控
        PerformanceMonitor.end();
    }
}
