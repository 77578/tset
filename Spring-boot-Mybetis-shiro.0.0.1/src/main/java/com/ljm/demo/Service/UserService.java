package com.ljm.demo.Service;


import com.ljm.demo.entity.User;

public interface UserService {
    //根据id查询用户
    public User Sel(int id);

    //根据name查询用户
    public  User Selname(String name);
}
