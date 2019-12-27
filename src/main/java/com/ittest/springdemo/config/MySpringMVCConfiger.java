package com.ittest.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 如果想保留 Spring Boot MVC的特性，而且还想扩展新的功能（拦截器, 格式化器, 视图控制器等），你可以
 * 在你自定义的 WebMvcConfigurer 类上增加 @Configuration 注解。
 */

@Configuration
public class MySpringMVCConfiger implements WebMvcConfigurer {

    //自定义视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/defineview").setViewName("success");
    }

    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHanderInterceptor())
                //拦截全部的请求
                .addPathPatterns("/**")
                //过滤不需要拦截的请求
                .excludePathPatterns("/","/index.html","/login")
                //排除静态资源的拦截
                .excludePathPatterns("/js/*","/img/*","/css/*");
    }
}
