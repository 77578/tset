package com.ljm.demo.Controller;


import com.ljm.demo.Service.UserService;
import com.ljm.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class shiroContrller {

    /**
     * 跳转主页
     * @param model
     * @return
     */
    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public String text(Model model){
        model.addAttribute("name","ljm");
        return "test";
    }
     //跳转add
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        System.out.println("add");
        return "User/add";
    }
    //跳转update
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(){
        return "User/update";
    }


    //跳转登入
    @RequestMapping(value = "/tologin",method = RequestMethod.GET)
    public String tologin(){
        return "login";
    }
    //登入
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public  String login(String name ,String password,Model model){
        System.out.println(123);
        /**
         * 使用shiro编写认证操作
         */
        //1.获取shiro
        Subject subject = SecurityUtils.getSubject();
        //2.封装数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        //3.执行登入方法
        try{
            subject.login(token);
            //登入成功
            return "redirect:/text";
        }catch (UnknownAccountException e){
           //登入失败用户名
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            //登入失败密码
            model.addAttribute("msg","密码名不存在");
            return "login";
        }
    }
    /*跳转没有授权的页面*/
    @RequestMapping(value = "/Unauthorized",method = RequestMethod.GET)
    public String Unauthorized(){
        return "Unauthorized";
    }

    /**
     * 测试数据
     */
    @Autowired
    private UserService userService;
    //跳转登入
    @RequestMapping(value = "/sh",method = RequestMethod.GET)
    @ResponseBody
    public String sh(){
        User sel = userService.Selname("acc");

        return sel.toString();
    }

}
