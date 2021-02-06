package com.atguigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

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
public class mySelfLBRule extends AbstractLoadBalancerRule  {

    private Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                int index = this.choosePollInt(serverCount);
                server = (Server)upList.get(index);
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    private int choosePollInt(int serverCount) {
        return getAndIncrement() % serverCount;
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }
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
}
