package com.ljm.demo.Dao;


import com.ljm.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface UserMapper {
   //根据id查询用户
    User Sel(int id);

    //根据name查询用户
    User Selname(String name);
}
