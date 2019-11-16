package com.ljm.mybetis.Dao;

import com.ljm.mybetis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface UserMapper {

    User Sel(int id);
}
