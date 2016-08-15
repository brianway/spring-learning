package com.brianway.learning.spring.aop.proxy;

/**
 * Created by brian on 16/6/24.
 * 业务接口
 */
public interface ForumService {
    void removeTopic(int topicId);

    void removeForum(int forumId);
}
