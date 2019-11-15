package com.ljm.my.Controller;

import com.ljm.my.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("stu")
public class HelloStudent {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        Student student01 = new Student(1001, "战神", 18);
        Student student02 = new Student(1002, "试试", 18);
        Student student03 = new Student(1003, "方法", 18);
        List<Student> list = new ArrayList();
        list.add(student01);
        list.add(student02);
        list.add(student03);
        model.addAttribute("list", list);

        System.out.println("这是list");
        return "list";
    }
}
