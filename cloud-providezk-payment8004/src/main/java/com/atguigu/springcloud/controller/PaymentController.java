package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-01
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/getZk")
    public String getZk(){
        return "SpringCloud with zookeeper port:"+serverPort + "\t" + UUID.randomUUID().toString();
    }
}
