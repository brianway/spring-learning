package com.brianway.learning.spring.aop.proxy;

/**
 * Created by brian on 16/6/24.
 * 只负责具体的业务逻辑,删除了性能监视的横切代码
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removeForum(int forumId) {
        System.out.println("模拟删除Topic记录" + forumId);

        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
