package com.zzf.zpmp.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: zpmp
 * @description
 * @author: zzf
 * @create: 2020-03-03 22:30
 **/
public class ShiroConfig {

    public SecurityManager securityManager(UserRealm)UserRealm
    //过滤链配置
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
        shiroFilter=new ShiroFilterFactoryBean();
        //设定用户没有登录认证时的跳转链接、
        shiroFilter.setLoginUrl("/login.html");
        //没有授权时的跳转链接
        shiroFilter.setUnauthorizedUrl("/");
        //过滤器链配置
        Map<String, String> filterMap = new LinkedHashMap();
//        filterMap.put("/swagger/**", "anon");
//        filterMap.put("/swagger-ui.html", "anon");
//        filterMap.put("/webjars/**", "anon");
//        filterMap.put("/swagger-resources/**", "anon");
        //匿名
        filterMap.put("/statics/**", "anon");
        filterMap.put("/login.html", "anon");
        filterMap.put("/sys/login", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/captcha.jpg", "anon");
        //必须登录
        filterMap.put("/**","authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return  shiroFilter;
    }
}
