package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import com.atguigu.myrule.mySelfLBRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

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
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = mySelfLBRule.class)
public class OrderMain8080 {
    public static void main(String [] args){
        SpringApplication.run(OrderMain8080.class,args);
    }
}
