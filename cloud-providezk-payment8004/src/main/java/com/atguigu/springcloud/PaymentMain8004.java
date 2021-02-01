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
 * @create: 2021-02-01
 **/
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时的注册服务开启
public class PaymentMain8004 {
    public static void main(String [] args){
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
