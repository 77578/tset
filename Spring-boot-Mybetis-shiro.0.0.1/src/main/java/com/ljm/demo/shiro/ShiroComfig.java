package com.ljm.demo.shiro;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置类
 * @Configuration 用于定义配置类，可替换xml配置文件
 */
@Configuration
public class ShiroComfig {


    /**
     * 1.创建 Realm
     * @Bean是一个方法级别上的注解，
     * 主要用在@Configuration注解的类里
     * 这个配置就等同于之前在xml里的配置
     * 添加的bean的id为方法名
     * <beans>
     *     <bean id="方法名" class=".."/>
     * </beans>
     *
     */
    @Bean(name = "getRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 2.创建 DefaultWebSecurityManager 安全管理器
     *
     */
     public DefaultWebSecurityManager gteDefaultWebSecurityManager(){
         DefaultWebSecurityManager SecurityManager = new DefaultWebSecurityManager();
         //关联Realm
         SecurityManager.setRealm(getRealm());
         return SecurityManager;
     }

    /**
     * 3.创建 ShiroFilterFactoryBean 过滤器
     * @return
     */
    @Bean(name = "getShiroFilterFactoryBean")
     public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
         ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
         //设置安全管理器
         shiroFilterFactoryBean.setSecurityManager(gteDefaultWebSecurityManager());

         /**
          * Shiro内置过滤器，可以实现权限相关的拦截器
          * 常用的过滤器:
          * anon:无需认证(登录)可以访问
          * authe:必须认证才可以访问
          * user:如果使用rememberMe的功能可以直接访问
          * perms:该资源必须得到资源权限才可以访问
          * role:该资源必须得到角色权限才可以访问
          * Shiro 拦截成功默认跳转 /login.jsp
          */
         Map<String, String> filterMap = new LinkedHashMap<String, String>();
         filterMap. put("/add","authc");//拦截
         filterMap. put("/update","authc");//拦截
         filterMap. put("/text","anon");//无需认证
         filterMap. put("/add","perms[user:add]");//授权过滤器
         filterMap. put("/update","perms[user:update]");//授权过滤器
         /* filterMap. put("/*","authc");//拦截所有*/

         shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

          //修改 hiro 拦截成功默认跳转
         shiroFilterFactoryBean.setLoginUrl("/tologin");
         //修改 hiro 默认授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/Unauthorized");

         return shiroFilterFactoryBean;
     }

}
