package com.ittest.springdemo.config;

import com.ittest.springdemo.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 配置注解类
 *
 * @Bean向容器中注入bean，id是方法名，注入的对象是方法返回的对象
 */
@Configuration
public class StudentConfig {

    @Bean
    public StudentService  studentService02(){
        System.out.println("StudnetService组件注入成功");
        return new StudentService();
    }
}
