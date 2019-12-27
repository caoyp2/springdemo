package com.ittest.springdemo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/*
    @Component 将Emp类丢入spring容器中进行管理
    @ConfigurationProperties(prefix = "emp")标识spring容器去配置文件中
    找emp对象来对该类中对应属性一一赋值
 */
@Component
@ConfigurationProperties(prefix = "emp")
public class Emp {
    private String name;
    private int age;
    private List list;
    private Map  map;
    private Sport sport;

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

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", map=" + map +
                ", sport=" + sport +
                '}';
    }
}
