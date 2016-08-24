package com.brianway.learning.spring.mvc.web;

import com.brianway.learning.spring.mvc.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class UserValidator implements Validator {
    private static String[] reservedUserNames = {"aaaa", "bbbb"};
    private static List<String> reservedUserNameList = Arrays
            .asList(reservedUserNames);

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public void validate(Object target, Errors errors) {
        if (target instanceof User) {
            User user = (User) target;
            if (reservedUserNameList.contains(user.getUserName())) {
                errors.rejectValue("userName", "reserved");
            }
        }
    }
}
