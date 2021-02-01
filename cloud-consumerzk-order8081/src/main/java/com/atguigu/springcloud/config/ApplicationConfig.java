package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-02
 **/
@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

}
