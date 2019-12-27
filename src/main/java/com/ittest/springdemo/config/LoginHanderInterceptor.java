package com.ittest.springdemo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class LoginHanderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        //不为null，说明有用户登录
        if(loginUser != null){
            return true;
        }

        //未登录时
        request.setAttribute("msg","没有权限，请先登录！"); //将信息放入request请求中
        //设置转发，转发/index.html请求
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
