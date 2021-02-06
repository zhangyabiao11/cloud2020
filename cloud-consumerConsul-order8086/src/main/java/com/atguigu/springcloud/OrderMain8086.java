package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-02
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain8086 {
    public static void main(String [] args){
        SpringApplication.run(OrderMain8086.class,args);
    }
}
