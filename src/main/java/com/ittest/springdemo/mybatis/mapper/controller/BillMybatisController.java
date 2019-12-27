package com.ittest.springdemo.mybatis.mapper.controller;

import com.ittest.springdemo.entities.Bill;
import com.ittest.springdemo.mybatis.mapper.BillConfigurationMapper;
import com.ittest.springdemo.mybatis.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BillMybatisController {

    //引入注解版
    @Autowired
    BillConfigurationMapper billConfigurationMapper;

//    通过配置文件引入mapper
    @Autowired
    BillMapper billMapper;

    @GetMapping("/billconfiguration/{bid}")
    public Map getBill(@PathVariable("bid") Integer bid){
        Map<String,Object> map = new HashMap<>();
        Bill bill = billConfigurationMapper.getBill(bid);
        map.put("data",bill);
        return map;
    }

    @GetMapping("/billxml/{bid}")
    public Map getBillByBid(@PathVariable("bid") Integer bid){
        Map<String,Object> map = new HashMap<>();
        Bill bill = billMapper.getBillByBid(bid);
        map.put("data",bill);
        return map;
    }


}
