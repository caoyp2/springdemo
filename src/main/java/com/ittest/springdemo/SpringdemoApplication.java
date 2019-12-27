package com.ittest.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @MapperScan("com.ittest.springdemo.mapper")
 * 会自动装配指定包下面所有Mapper，省得在每个Mapper上面写@Mapper注解
 */
@EnableCaching //开启缓存
@EnableScheduling //开启定时
@EnableAsync  //开启异步
@MapperScan("com.ittest.springdemo.mybatis.mapper")
@ImportResource(locations={"classpath:spring01.xml"})
@SpringBootApplication
public class SpringdemoApplication {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        SpringApplication.run(SpringdemoApplication.class, args);
    }

}

