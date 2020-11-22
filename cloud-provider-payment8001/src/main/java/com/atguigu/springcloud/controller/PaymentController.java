package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2020-11-17
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null)
            return new CommonResult<>(500,"查询失败");
        return new CommonResult<>(200,"查询成功",payment);
    }
    @PostMapping("payment/create")
    public CommonResult<Integer> create(Payment payment){
        int result = paymentService.create(payment);
        log.info("**********插入结果:"+result);
        if (result > 0){
            return new CommonResult<>(200,"插入数据库成功！",result);
        }
        return new CommonResult<>(500,"插入失败",result);
    }


}