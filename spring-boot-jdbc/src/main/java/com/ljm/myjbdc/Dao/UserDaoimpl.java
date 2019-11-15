package com.ljm.myjbdc.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoimpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void adduser(String name,String password){

        String sql="insert user (name,password) values (?,?)";
        jdbcTemplate.update(sql, name, password);

    }
}
