package com.brianway.learning.spring.mvc.domain;

import java.beans.PropertyEditorSupport;

public class UserEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        if (text != null) {
            String[] items = text.split(":");
            user.setUserId(items[0]);
            user.setUserName(items[1] + " by propertyeEditor");
            user.setPassword(items[2]);
        }
        setValue(user);
    }
}
