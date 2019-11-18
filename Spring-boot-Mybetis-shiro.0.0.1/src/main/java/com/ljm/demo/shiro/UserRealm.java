package com.ljm.demo.shiro;



import com.ljm.demo.Service.UserService;
import com.ljm.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
   private UserService userService;
    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        //模拟数据
        String name ="acc";
        String password="123456";

        //shiro 编写逻辑 判断用户密码
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;

        //查询数据库
        User user = userService.Selname(token.getUsername());

        if (user==null){
          //用户不存在
          return null;
        }
        //判断密码                      传递user    密码
        return new SimpleAuthenticationInfo(user,user.getPassWord(),"");
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加授权字符串
        //获取传递的User
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();

         info.addStringPermission(principal.getRealName());

        return info;
    }


}
