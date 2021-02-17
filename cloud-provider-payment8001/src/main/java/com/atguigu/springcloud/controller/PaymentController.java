package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null)
            return new CommonResult<>(500,"查询失败");
        return new CommonResult<>(200,"查询成功,serverPort="+serverPort,payment);
    }
    @PostMapping("payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("**********插入结果:"+result);
        if (result > 0){
            return new CommonResult<>(200,"插入数据库成功！serverPort="+serverPort,result);
        }
        return new CommonResult<>(500,"插入失败",result);
    }

    @GetMapping("payment/discovery")
    public DiscoveryClient discovery(){

        List<String> services = discoveryClient.getServices();
        for (String service:services) {
            log.info("service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("provide/info")
    private String getPayment(){
        return serverPort;
    }

    @GetMapping("provide/info/timeout")
    public String getPaymentTimeOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
