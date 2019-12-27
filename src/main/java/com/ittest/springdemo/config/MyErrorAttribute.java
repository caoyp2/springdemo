package com.ittest.springdemo.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 封装自定义的错误信息数据
 */
@Component  //将MyErrorAttribute组件丢入容器中
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map  =  super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","cyp company");
        return map;
    }
}
