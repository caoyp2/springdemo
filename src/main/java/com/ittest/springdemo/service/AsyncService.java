package com.ittest.springdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步处理批量任务是可使用
 *在springboot上开启@EnableAsync注解
 * 在需要异步的方法上加上异步注解 @Async
 */
@Service
public class AsyncService {

    //加上异步注解
    @Async
    public void async(){
        try {
            Thread.sleep(3*1000);
            System.out.println("批量处理任务。。。。。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
