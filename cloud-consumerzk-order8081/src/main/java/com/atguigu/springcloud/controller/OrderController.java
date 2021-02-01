package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-02
 **/
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String INVOKE_URL ="http://cloud-provider-payment";

    @GetMapping("consumer/payment/getZk")
    public String getZk(){

        return restTemplate.getForObject(INVOKE_URL+"/payment/getZk",String.class);
    }

}
