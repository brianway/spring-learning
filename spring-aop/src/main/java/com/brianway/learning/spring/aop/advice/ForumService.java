package com.brianway.learning.spring.aop.advice;

import java.sql.SQLException;

public class ForumService {
    public void removeForum(int forumId) {
        // do sth...
        throw new RuntimeException("运行异常。");
    }

    public void updateForum(Forum forum) throws Exception {
        // do sth...
        throw new SQLException("数据更新操作异常。");

    }
}
