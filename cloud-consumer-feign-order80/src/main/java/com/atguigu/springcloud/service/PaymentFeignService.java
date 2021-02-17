package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-06
 **/
@Component
@FeignClient(name = "PAYMENT")
public interface PaymentFeignService {
    @GetMapping("provide/info")
    String getPayment();
    @GetMapping("provide/info/timeout")
    String getPaymentTimeOut(); //注意请求路径和方法定义都要一致！！！
}
