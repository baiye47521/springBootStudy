package com.hand.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author ludongpeng
 * @Date 2020/12/25 10:09
 * @Description:
 */
@Configuration
public class ShiroConfig {

    //shiroFilterFactoryBean：3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
            anon:   无需认证就可以访问
            authc:  必须认证才能访问
            user:   必须拥有记住我功能才能访问
            perms:  拥有对某个资源的权限才能访问
            role:  拥有某个角色权限才能访问
        * */
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
        //授权,无授权跳转到未授权页
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        bean.setFilterChainDefinitionMap(filterMap);
        //登陆
        bean.setLoginUrl("/toLogin");
        //未授权页
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }
    //DefaultWebSecurityManager：2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建realm对象 自定义类:1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect：用来整合shiro和thymealeaf
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
