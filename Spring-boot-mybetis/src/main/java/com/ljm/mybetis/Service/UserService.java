package com.ljm.mybetis.Service;


import com.ljm.mybetis.Dao.UserMapper;
import com.ljm.mybetis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private UserMapper userMapper;

    public User Sel(int id) {
        System.out.println("这是UserService");
        return userMapper.Sel(id);
    }
}