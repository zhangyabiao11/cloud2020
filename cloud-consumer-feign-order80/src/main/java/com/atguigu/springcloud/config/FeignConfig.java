package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-17
 **/
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level getLevel(){
        return Logger.Level.FULL;
    }
}
