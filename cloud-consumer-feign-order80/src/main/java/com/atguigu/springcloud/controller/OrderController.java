package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-06
 **/
@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("consumer/payment/getInfo")
    public String get(){
        return paymentFeignService.getPayment();
    }

    @GetMapping("consumer/payment/timeout")
    public String getTimeout(){
        return paymentFeignService.getPaymentTimeOut();
    }

}
