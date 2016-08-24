package com.brianway.learning.spring.mvc.domain;

import org.springframework.core.convert.converter.Converter;

public class StringToUserConverter implements Converter<String, User> {
    public User convert(String source) {
        User user = new User();
        if (source != null) {
            String[] items = source.split(":");
            user.setUserId(items[0]);
            user.setUserName(items[1]);
            user.setPassword(items[2]);
        }
        return user;
    }
}
