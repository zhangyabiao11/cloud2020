package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 *   主启动类
 * </p>
 *
 * @author: zhangyb
 * @create: 2020-11-16
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String [] args){
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
