package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2020-11-22
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class OrderMain8080 {
    public static void main(String [] args){
        SpringApplication.run(OrderMain8080.class,args);
    }
}
