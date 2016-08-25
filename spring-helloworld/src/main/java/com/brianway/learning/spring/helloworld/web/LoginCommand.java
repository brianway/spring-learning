package com.brianway.learning.spring.helloworld.web;

/**
 * Created by Brian on 2016/5/12.
 */
public class LoginCommand {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
