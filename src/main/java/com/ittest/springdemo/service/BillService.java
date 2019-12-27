package com.ittest.springdemo.service;

import com.ittest.springdemo.mybatis.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    BillMapper billMapper;

}
