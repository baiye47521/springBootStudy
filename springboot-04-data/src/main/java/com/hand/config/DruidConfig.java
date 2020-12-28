package com.hand.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @Author ludongpeng
 * @Date 2020/12/14 17:28
 * @Description:
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控：web.xml
    //因为springboot内置了servlet容齐，所有没有web.xml，所有可以用替代方法
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //账号密码

        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername", "admin");//登陆的key是固定的 loginUsername
        initParameters.put("loginPassword", "123");//登陆的key是固定的 loginPassword
        //允许谁能访问
        initParameters.put("allow", "");
        //禁止谁访问
//        initParameters.put("hand","192.168.11.12");
        bean.setInitParameters(initParameters);
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStartFilter(){

        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        //过滤哪些请求
        HashMap<String, String> initParameters = new HashMap<>();

        //不进行统计
        initParameters.put("exclusions","*.js, *.css,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;
    }

}
