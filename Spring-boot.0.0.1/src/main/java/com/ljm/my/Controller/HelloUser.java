package com.ljm.my.Controller;


import com.ljm.my.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloUser {

    @RequestMapping("hello/{id}")
    @ResponseBody
    public User Holleuser(@PathVariable() Integer id) {
        User user = new User();
        user.setId(id);
        user.setPassword("123456");
        user.setUsername("Ljm");
        System.out.println(123);
        return user;
    }
}
