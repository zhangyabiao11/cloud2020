package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private PaymentFeignService feignService;

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return feignService.get(id);
    }

}
