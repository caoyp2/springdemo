package com.ittest.springdemo.controller;

import com.ittest.springdemo.entities.User;
import com.ittest.springdemo.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;


    @GetMapping("/users")
    public String getUsers(Map<String,Object> map, User user){
        List<User> users = userMapper.getUsers(user);
        map.put("users",users);
        map.put("username",user.getUsername());
        return "user/list";
    }

    @GetMapping("/user/{id}")
    public String getUserById(Map<String,Object> map,
                              @PathVariable("id") Integer id,
                              @RequestParam(value = "type",defaultValue = "view") String type){
        User user = userMapper.getUserById(id);
        map.put("user",user);

        return "user/" + type;
    }

    @GetMapping("/user")
    public String toBill(Map<String,Object> map){
        return "user/add";
    }

    @PostMapping("/user")
    public String addUser(User user){

        userMapper.addUser(user);
        return "redirect:/users";
    }

    @PutMapping("/user")
    public String updateUser(User user){
        userMapper.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userMapper.deleteUserById(id);
        return "redirect:/users";
    }
}
