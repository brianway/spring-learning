package com.brianway.learning.spring.helloworld.dao;

/**
 * Created by Brian on 2016/5/11.
 */
import com.brianway.learning.spring.helloworld.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName,String password){
        String sqlStr = "SELECT count(*) FROM t_user WHERE user_name = ? and password = ?";
        //return jdbcTemplate.queryForObject(sqlStr,new Object[]{userName,password},Integer.class);
        /*
        JdbcTemplate queryForInt/Long is deprecated in Spring 3.2.2. What should it be replaced by?
        http://stackoverflow.com/questions/15661313/jdbctemplate-queryforint-long-is-deprecated-in-spring-3-2-2-what-should-it-be-r
         */
        return jdbcTemplate.queryForObject(sqlStr,Integer.class,userName,password);
    }

    public User findUserByUserName(final String userName){
        String sqlStr = "SELECT user_id,user_name,credits FROM t_user WHERE user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName},
                new RowCallbackHandler() {
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(resultSet.getInt("credits"));
                    }
                });
        return user;
    }

    public void updateLoginInfo(User user){
        String sqlStr = "UPDATE t_user SET last_visit=?,last_ip=?,credits=? WHERE user_id=?";
        jdbcTemplate.update(sqlStr,user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId());
    }
}

