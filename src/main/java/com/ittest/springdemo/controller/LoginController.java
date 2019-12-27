package com.ittest.springdemo.controller;

import com.ittest.springdemo.entities.User;
import com.ittest.springdemo.mybatis.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, Map<String,Object> map){
        User user = userMapper.getUserByNameAndPwd(username, password);
        if( user != null){
           session.setAttribute("loginUser",username);
           return "redirect:/main.html";
        }
        //登录失败
        map.put("msg","用户名或密码错误");
        return "main/login";
    }

    @GetMapping("/loginout")
    public String loginout(HttpSession session){
        //清除登录用户的信息
        session.removeAttribute("loginUser");
        //清除session
        session.invalidate();

        //跳转到登录页面
        return "redirect:/index.html";
    }

    @GetMapping("/password")
    public String toPassword(){
        return "main/password";
    }

    @GetMapping("/oldpassword")
    @ResponseBody
    public Boolean oldPassword(HttpServletRequest request,String oldPassword){
        String username = (String) request.getSession().getAttribute("loginUser");
        User user = userMapper.getUserByNameAndPwd(username, oldPassword);
        if(user != null){
            return true;
        }
        return false;
    }

    @PostMapping("/password")
    @ResponseBody
    public Boolean modifyPassword(HttpServletRequest request,
                                 String password){
        logger.info(password);
        String username = (String) request.getSession().getAttribute("loginUser");
        userMapper.modifyPassword(username,password);
        //跳转到登录页面
        return true;
    }

}
