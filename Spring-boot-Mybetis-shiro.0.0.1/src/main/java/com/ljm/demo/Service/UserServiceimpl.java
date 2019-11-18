package com.ljm.demo.Service;



import com.ljm.demo.Dao.UserMapper;
import com.ljm.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//spring-boot默认配置一个事物管理器
@Transactional
public class UserServiceimpl implements UserService {

    @Autowired
   private UserMapper userMapper;
    //根据id查询用户
    @Override
    public User Sel(int id) {
        System.out.println("这是UserService");
        return userMapper.Sel(id);
    }
    //根据name查询用户
    @Override
    public User Selname(String name) {
        System.out.println("这是UserService");
        return userMapper.Selname(name);
    }



}