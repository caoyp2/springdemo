package com.ittest.springdemo.service;

import org.springframework.stereotype.Service;

//@Service
public class StudentService {

    public String add(){
        System.out.println("add()..........");
        return "add";
    }
}
