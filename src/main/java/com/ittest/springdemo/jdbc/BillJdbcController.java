package com.ittest.springdemo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @RestController注解作用相当于使用@Controller和@ResponseBody
 *
 */
@RestController
public class BillJdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/billlistjdbc")
    public Map bill(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from bill");
        Map<String, Object> map = new HashMap<>();
        map.put("data",maps);
        return map;
    }

}
