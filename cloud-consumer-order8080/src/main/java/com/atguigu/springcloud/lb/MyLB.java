package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author: zhangyb
 * @create: 2021-02-06
 **/
@Component
public class MyLB implements LoadBalance {

    /**
     * 原子操作类用以CAS操作
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 自旋锁来获取下一次访问序列
     * @return 访问系列号
     */
    private int getAndIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("***********第几次访问，次数为："+next);
        return next;
    }

    /**
     * 获取服务信息
     * @param serviceInstances 总的服务列表
     * @return 当前服务
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
