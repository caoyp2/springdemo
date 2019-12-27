package com.ittest.springdemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务
 * 在入口类上添加注解@EnableScheduling
 * 在需要的定时方法上添加注解
 */
@Service
public class SchedulService {

    /*分别对应：
      秒 分 时 天 月 周
     *"0 * * * * * MON-FRI"
     */
    @Scheduled(cron = "*/3 * * * * MON-FRI")
    public void schedul(){
        System.out.println("定时执行。。。。" );
    }
}
