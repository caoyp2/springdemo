package com.ittest.springdemo.controller;

import com.ittest.springdemo.bean.User;
import com.ittest.springdemo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class InitController {

    @RequestMapping("/init")
    @ResponseBody
    public String init(){
        return "hello init.............";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //会在存放的资源文件中去找success.html
        map.put("name","大大大大");
        return "success";
    }

    @RequestMapping("/user")
    public String student(Map<String,Object> map){
        List<User> list = new ArrayList<>();
        list.add(new User("张三",1));
        list.add(new User("李四",2));
        list.add(new User("王五",1));
        map.put("userlist",list);
        map.put("sex",1);
        map.put("userobj",new User("大大",2));
        map.put("text","<h1>hello world </h1>");
        return "User";
    }

    @Autowired
    AsyncService asyncService;

    @GetMapping("/async")
    @ResponseBody
    public String success(){
        asyncService.async();
        return "success";
    }
}
