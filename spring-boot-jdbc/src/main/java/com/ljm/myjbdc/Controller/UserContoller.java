package com.ljm.myjbdc.Controller;

import com.ljm.myjbdc.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserContoller {

    @Autowired
    private Userservice userservice;

    @RequestMapping("acc")
    @ResponseBody
    public String addUser(String name,String password){

        userservice.adduser(name,password);

        return "成功+访问地址http://localhost:8080/acc?name=a&password=123";
    }

}
