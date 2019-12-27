package com.ittest.springdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${student.name}")
    private String name;

    @RequestMapping("/sayhello")
    @ResponseBody
    public String sayHello(){
        return "say Hello" + name;
    }
}
