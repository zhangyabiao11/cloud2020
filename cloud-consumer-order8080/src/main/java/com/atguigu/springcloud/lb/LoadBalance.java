package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-06
 **/
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
