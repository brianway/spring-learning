package com.brianway.learning.spring.helloworld.service;

import com.brianway.learning.spring.helloworld.dao.LoginLogDao;
import com.brianway.learning.spring.helloworld.dao.UserDao;
import com.brianway.learning.spring.helloworld.domain.LoginLog;
import com.brianway.learning.spring.helloworld.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Brian on 2016/5/11.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}
