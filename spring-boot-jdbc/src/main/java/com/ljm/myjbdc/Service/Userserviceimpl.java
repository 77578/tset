package com.ljm.myjbdc.Service;

import com.ljm.myjbdc.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userserviceimpl implements Userservice {

    @Autowired
    private UserDao userDao;

    @Override
    public void adduser(String name, String password) {
        userDao.adduser(name, password);
    }
}
