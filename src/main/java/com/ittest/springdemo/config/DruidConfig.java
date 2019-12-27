package com.ittest.springdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //绑定数据源配置
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }



    /**
     * 配置Druid监控
     * 1. 配置一个管理后台的Servlet
     * 2. 配置一个监控的filter
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){

        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map<String, String> initParams = new HashMap<>();
        initParams.put(ResourceServlet.PARAM_NAME_USERNAME,"admin");
        initParams.put(ResourceServlet.PARAM_NAME_PASSWORD,"123456");
        bean.setInitParameters(initParams);

        return bean;
    }

    //配置过滤器
    @Bean
    public FilterRegistrationBean filter(){
        FilterRegistrationBean filterRegistrationBean =
                new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());

        return filterRegistrationBean;
    }

}
