package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-19
 **/
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String [] args){
        SpringApplication.run(GateWayMain9527.class,args);
    }
}
