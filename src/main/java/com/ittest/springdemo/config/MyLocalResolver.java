package com.ittest.springdemo.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义区域解析器
 */
public class MyLocalResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String parameter = httpServletRequest.getParameter("l");

        //添加默认的区域
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(parameter)){
            String[] data = parameter.split("_");
            //设置解析的预期信息
            locale = new Locale(data[0],data[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
