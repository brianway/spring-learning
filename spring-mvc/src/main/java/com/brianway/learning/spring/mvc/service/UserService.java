package com.brianway.learning.spring.mvc.service;

import com.brianway.learning.spring.mvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class UserService {

    public void createUser(User user) {
        System.out.println("save user.");
    }

    public User getUserById(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("test");
        return user;
    }

    public List<User> getUsers() {
        Calendar calendar = new GregorianCalendar();
        List<User> users = new ArrayList<User>();
        calendar.set(1980, Calendar.JANUARY, 1);

        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        user1.setRealName("汤姆");
        user1.setBirthday(calendar.getTime());

        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());

        User user3 = new User();
        user3.setUserName("brian");
        user3.setRealName("布朗");
        user3.setBirthday(calendar.getTime());

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }

}
