package com.ittest.springdemo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

/*
    @Component 将Emp类丢入spring容器中进行管理
    @ConfigurationProperties(prefix = "emp")标识spring容器去配置文件中
    找emp对象来对该类中对应属性一一赋值
    @ConfigurationProperties()注入方式能和@Validated一起使用，@Value不能使用
    同时使用@ConfigurationProperties和@Value对同一属性赋值，会以@ConfigurationProperties为主

    @PropertySource用来加载局部配置文件
 */

@PropertySource("classpath:student.properties")
@Validated
@Component
@ConfigurationProperties(prefix = "student")
public class Student {


//    @Value("${student.name}")
//    @Email
    private String name;
    @Value("#{10 * 2}")
    private int age;
    private Map map;
    private List list;
    private Course course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", map=" + map +
                ", list=" + list +
                ", course=" + course +
                '}';
    }
}
