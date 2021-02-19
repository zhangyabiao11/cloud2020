# SpringCloud

SpringCloud第二季2020.3版，尚硅谷周阳老师。-2020年11月16日开始。

大纲：

![image-20201116210113927](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116210113927.png)

课程内容：SpringCloud+SpringCloud alibaba，微服务的各个技术栈的演化过程。

## 微服务架构与SpringCloud

### 01,微服务架构理论入门

微服务架构的思想是Martin Fowler在2014年提出的一种架构模式：

![image-20201116204851517](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116204851517.png)

架构模式：——天上的思想

![image-20201116205238731](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205238731.png)

技术栈：——落地的实现

![image-20201116205210877](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205210877.png)

### 02.什么是SpringCloud?

![image-20201116205344126](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205344126.png)

落地实现的方式：

![image-20201116205450287](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205450287.png)

SpringCloud俨然已成为微服务开发的主流技术栈。

京东的微服务架构：

![image-20201116205606166](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205606166.png)

阿里的

![image-20201116205635577](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205635577.png)

京东物流：

![image-20201116205655276](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205655276.png)

业务与服务：

![image-20201116205759664](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205759664.png)



### 03.SpringCloud的技术栈

![image-20201116205914660](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205914660.png)

主流的技术栈：

![image-20201116205942009](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116205942009.png)

随着技术的发展，这些落地的实现也被一波一波的被取代：

## SpringCloud

分为上下篇：

上篇：springBoot2.x版和SpringCloudH版；下篇：springCloud Alibaba.

### 01.版本选择：

去Spring官网：https://spring.io

这里的版本选择:

![image-20201116211355643](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116211355643.png)

### 02.Cloud各种组件的停更说明

![image-20201116211606118](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116211606118.png)

springCloud官网资料：

https://cloud.spring.io/spring-cloud-static/Hoxton.SR1/reference/htmlsingle/

中文文档：

https://www.bookstack.cn/read/spring-cloud-docs/docs-index.md

SpringBoot官网文档

https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/

### 03.微服务架构编码构建-父工程

1.SpringBoot开始：约定>配置>编码

2.父工程的开发步骤：

1. new Project
2. 聚合总父工程的名字
3. Maven选版本(镜像)
4. 工程名字
5. 字符编码
6. 注解失效激活
7. Java编译版本选8
8. File Type过滤

![image-20201116213456992](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116213456992.png)

![image-20201116213537971](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116213537971.png)

![image-20201116213601266](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116213601266.png)

3.父工程的Pom配置

1. 删去多余的内容，只留pom.xml

   ![image-20201116214043397](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201116214043397.png)

2. 配置pom文件中的packaging

3. 统一jar包管理

   ```xml
   <groupId>com.atguigu.springcloud</groupId>
   <artifactId>cloud2020</artifactId>
   <version>1.0-SNAPSHOT</version>
   <packaging>pom</packaging>
   
   <!-- 统一管理jar包版本-->
   <properties>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       <maven.compiler.source>1.8</maven.compiler.source>
       <maven.compiler.target>1.8</maven.compiler.target>
       <junit.version>4.12</junit.version>
       <log4j.version>1.2.17</log4j.version>
       <lombok.version>1.16.18</lombok.version>
       <mysql.version>5.1.47</mysql.version>
       <druid.version>1.1.16</druid.version>
       <mybatis.spring.boot.version>1.3.0</mybatis.spring.boot.version>
   </properties>
   
   <!-- 子模块继承后，提供作用:锁定版本+子module不用写groupId和version,并不引入jar包，当子类module引用时才引入-->
   <dependencyManagement>
       <dependencies>
           <dependency>
               <groupId>org.springframework.cloud</groupId>
               <artifactId>spring-cloud-dependencies</artifactId>
               <version>Hoxton.SR1</version>
               <type>pom</type>
               <scope>import</scope>
           </dependency>
           <dependency>
               <groupId>com.alibaba.cloud</groupId>
               <artifactId>spring-cloud-alibaba-dependencies</artifactId>
               <version>2.1.0.RELEASE</version>
               <type>pom</type>
               <scope>import</scope>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-dependencies</artifactId>
               <version>2.2.2.RELEASE</version>
               <type>pom</type>
               <scope>import</scope>
           </dependency>
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <version>${mysql.version}</version>
           </dependency>
           <dependency>
               <groupId>com.alibaba</groupId>
               <artifactId>druid</artifactId>
               <version>${druid.version}</version>
           </dependency>
           <dependency>
               <groupId>org.mybatis.spring.boot</groupId>
               <artifactId>mybatis-spring-boot-starter</artifactId>
               <version>${mybatis.spring.boot.version}</version>
           </dependency>
       </dependencies>
   </dependencyManagement>
   ```

4. dependencyManagement与dependencies



### 04.Rest微服务工程构建-消费者

工程构建步骤：

1. 建module
2. 改pom
3. 写YML
4. 主启动
5. 业务类
6. 测试

开启热部署：

1. 添加依赖:在module中添加依赖:

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-devtools</artifactId>
       <scope>runtime</scope>
       <optional>true</optional>
   </dependency>
   ```

2. 添加一个插件:在父工程中添加一个插件:

   ```xml
    <build>
           <finalName>cloud-provider-payment8001</finalName>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
                   <configuration>
                       <fork>true</fork>
                       <addResources>true</addResources>
                   </configuration>
               </plugin>
           </plugins>
       </build>
   ```

3. 开启自动编译设置：

   ![image-20201117234616266](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201117234616266.png)

4. 开启自动加载：快捷键Ctrl+alt+shift+/，然后选择register,选中以下两个:

   ![image-20201117235223473](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201117235223473.png)

5. 配置当离开idea时热部署：

   ![image-20201117235526243](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201117235526243.png)

### 05.消费者模块开发

建消费者模块cloud-consumer-order8080，步骤同上。

RestTemplate提供了多种便捷访问远程Http服务的方法，是一种便捷访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集。

解决配置文件无法加载问题

### 06.项目重构

建公共模块cloud-api-commons，步骤同上。

将两个项目中的entities包迁移到公共模块下，并引入公共模块：

```xml
<dependency>
    <groupId>com.atguigu.springcloud</groupId>
    <artifactId>cloud-api-commons</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### 07.Eureka

1.基础知识：

- 什么是服务治理：

  ![image-20210127233532102](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210127233532102.png)

- 什么是服务注册

  ![image-20210127233642445](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210127233642445.png)

- Eureka两组件

  ![image-20210127234004198](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210127234004198.png)

2.单机版Eureka搭建

建服务注册模块cloud-eureka-server7001，步骤同上。

yml中配置eureka,并且主启动类要加@EnableEurekaServer注解

将8080和8081模块注入到eureka服务

改pom->写yml->主启动

3.集群Eureka构建步骤：

集群原理：互相注册，相互守望

建服务注册模块cloud-eureka-server7002，步骤同上。

修改配置文件hosts:127.0.0.1 eureka7001.com

127.0.0.1 eureka7002.com

修改yml,主启动。

4.将业务模块注册进入eureka集群

（问题：两个业务模块只注册进7001，没有注册进7002，

​	解决：defaultZone写错了，

相关博客：https://www.jianshu.com/p/788745f7dc7d）

5.支付微服务集群配置

首先创建支付模块cloud-provide-payment8002，步骤同上。

pom和yml以及业务类都与payment8001一致即可，这里只需在Controller类中输出一个端口区分即可：

```java
@Value("${server.port}")
private String serverPort;
```

然后更新订单模块的请求地址为服务的名称：

```java
//private static final String PAYMENT_URL="http://localhost:8001";
private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
```

并且要在RestTemplate类上增加一个注解@LoadBalanced使它支持负载均衡。

```java
@Bean
@LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡能力
public RestTemplate getRestTemplate(){
    return new RestTemplate();
}
```

这样就实现了消费者模块负载均衡地请求分布式生产者模块的服务了。

6.actuator微服务信息完善

首先服务名称修改：

```xml
eureka:
  instance:
    instance-id: payment8001
```

然后访问信息有IP信息提示：

```xml
eureka:
  instance:
    instance-id: payment8001
    prefer-ip-address: true
```

7.服务发现Discovery

提供微服务实例的相关信息

```java
import org.springframework.cloud.client.discovery.DiscoveryClient;
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private DiscoveryClient discoveryClient;
    
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
}
```

```java
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String [] args){
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
```

8.Eureka自我保护机制

网络延迟->自我保护-宁可保留错误的信息，也不盲目注销任何可能健康的微服务->使得微服务更加的健壮，稳定。属于CAP里面的AP思想。

怎么禁止自我保护？

```xml
eureka:  
  server:
    enable-self-preservation: false #自我保护机制
    eviction-interval-timer-in-ms: 2000
```

服务心跳配置

```xml
eureka:
  instance:
    instance-id: payment8002
    prefer-ip-address: true
    #Eureka客户端向服务端发送心跳的时间间隔，单位秒(默认为30秒)
    lease-renewal-interval-in-seconds: 30
    #Eureka服务端在收到最后一次心跳后等待时间上限，单位秒(默认为90秒)，超时将剔除服务
    lease-expiration-duration-in-seconds: 90
```

### 08.Zookeeper

1.Eureka停更

2.SpringCloud整合Zookeeper替换Eureka

首先在虚拟机中安装Zookeeper(前提虚拟机环境可用，防火墙关闭)，参考P28

然后新建cloud-providezk-payment8004服务并注册到zookeeper中，注意jar包冲突。

测试并查看zookeeper中的服务注册信息。

3.zookeeper有没有自我保护机制？->服务节点是临时还是持久的？->临时节点。

4.订单服务注册到Zookeeper中。

新建cloud-consumerzk-order8081服务并注册到zookeeper中

5.Zookeeper集群配置。



### 09.Consul

1.consul简介

是什么 能干啥 去哪下 怎么玩 参见[官网](https://www.consul.io/)

2.安装并运行Consul

下载并安装，然后cmd运行consul agent -dev

consul首页：http://localhost:8500	

3.服务提供者注册到consul

新建cloud-providerConsul-payment8006服务并注册到consul中

4.服务消费者注册到consul中

新建cloud-consumerConsul-order8086服务并注册到consul中

5.三个注册中心的异同

![image-20210202234102819](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210202234102819.png)

CAP:

![image-20210202234128433](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210202234128433.png)

C:Consistency 强一致性

A:Availability 可用性

P:Partition tolerance 分区容错性

CAP理论关注粒度是数据，而不是整体系统设计的策略。

CAP最多只能同时较好的满足两个。

CAP理论的核心是：一个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求，因此，根据CAP理论原来将NoSQL数据库分成了满足CA原则，满足CP原则和满足AP原则三大类：

CA-单体集群，满足一致性，可用性的系统，通常在可扩展性上不太强大。

CP-满足一致性，分区容忍必的系统，通常性能不是特别高。

AP-满足可用性，分区容忍性的系统，通常可能对一致性要求低一些。

举例：

AP架构：当网络分区出现后，为了保证可用性，系统B可用返回旧值，保证系统的可用性。

![image-20210202235204540](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210202235204540.png)

 结论：违背了一致性C的要求，只满足可用性和分区容错，即AP

CP：当网络分区出现后，为了保证一致性，就必须拒接请求，否则无法保证一致性。

![image-20210202235640385](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210202235640385.png)

结论：违背了可用性A的要求，只满足一致性和分区容错，即CP

### 10.Ribbon

1.概述

是什么：SpringCloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。简单的说，Ribbon是Netflix发步的开源项目，主要功能是提供客户端的软件负载均衡算法和服务调用.Ribbon客户端组件提供一系列完善的配置项如连接超时，重试等。简单的说，就是在配置文件中列出Load Balancer(简称LB)所有的机器，Ribbon会自动的帮助你基于某种规则(如简单轮询，随机连接等)去连接这些机器。我们很容易使用RIbbon实现自定义的负载均衡算法。

能干啥：[官网](https://github.com/Netflix/ribbon/wiki/Getting-Started)  目前已经进入维护模式

LB(Load Balance负载均衡)：将用户的请求平摊的分配到多个服务上，从而达到HA(高可用)。常见的负载均衡有Nginx,LVS，硬件F5等

	- 集中式LB：即在服务的消费方和提供方之间使用独立的LB设施(可以是软件，如nignx,可以是硬件,如F5),由该设施负责把访问请求通过某种策略转发到服务的提供方。
	- 进程内LB：将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选择出一个合适的服务器。Ribbon就属于进程内，它只是一个类库，集成于消费方进程，消费方通过它来获取到服务提供方的地址。

Ribbon本地负载均衡客户端 VS Nginx服务端负载均衡区别：

- Nginx是服务器负载均衡，客户端所有请求都会交给nginx，然后由nginx实现转发请求。即负载均衡是由服务端实现的。
- Ribbon本地负载均衡，在调用微服务接口时，会在注册中心上获取注册信息服务列表之后缓存到JVM本地，从而在本地实现RPC远程服务调用技术。

一句话：负载均衡+RestTemplate调用

2.负载均衡的使用

架构说明：

![image-20210203231358388](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210203231358388.png)

![image-20210203231428760](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210203231428760.png)

总结：Ribbon其实就是一个软负载均衡的客户端组件，它可用和其他所需请求的客户端结合使用，和eureka结合只是其中的一个实例。

POM引入：在新的netflix-eureka-client中集成了netflix-ribbon因此eureka自带负载均衡。

细说RestTemplate.

3.Ribbon核心组件IRule

IRule:根据特定算法中从服务列表中选取一个要访问的服务。

![image-20210203232913075](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210203232913075.png)

Ribbon自带的常用的规则：

![image-20210203232851201](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210203232851201.png)

4.负载均衡规则如何替换：

修改cloud-consumer-order8080服务；

注意自定义配置的规则不能放在@ComponentScan所扫描的当前包下以及子包下，否则自定义规则就会被所有Ribbon客户端所共享，达不到特殊定制化的目的了。

新建package:com.atguigu.myrule

上面包下新建MySelfRule规则类

```java
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){

        return new RandomRule();
    }
}
```

主启动类添加@RibbonClient

```java
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "cloud-provider-payment",configuration = MySelfRule.class)
public class OrderMain8080 {
    public static void main(String [] args){
        SpringApplication.run(OrderMain8080.class,args);
    }
}
```

5.负载均衡算法分析：

原理：

总计数：2台 List = 2 instance

1 % 2 = 1 -> index = 1 list.get(1);

2 % 2 = 0 -> index = 0 list.get(0);

3 % 2 = 1 -> index = 1 list.get(1);

……

源码：IRule及其实现类

如轮询：CAS+自旋锁

```java
public class RoundRobinRule extends AbstractLoadBalancerRule {
    private AtomicInteger nextServerCyclicCounter;
    public RoundRobinRule() {
        this.nextServerCyclicCounter = new AtomicInteger(0);
    }
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        } else {
            Server server = null;
            int count = 0;

            while(true) {
                if (server == null && count++ < 10) {
                    List<Server> reachableServers = lb.getReachableServers();
                    List<Server> allServers = lb.getAllServers();
                    int upCount = reachableServers.size();
                    int serverCount = allServers.size();
                    if (upCount != 0 && serverCount != 0) {
                        int nextServerIndex = this.incrementAndGetModulo(serverCount);
                        server = (Server)allServers.get(nextServerIndex);
                        if (server == null) {
                            Thread.yield();
                        } else {
                            if (server.isAlive() && server.isReadyToServe()) {
                                return server;
                            }

                            server = null;
                        }
                        continue;
                    }

                    log.warn("No up servers available from load balancer: " + lb);
                    return null;
                }

                if (count >= 10) {
                    log.warn("No available alive servers after 10 tries from load balancer: " + lb);
                }

                return server;
            }
        }
    }
    private int incrementAndGetModulo(int modulo) {
        int current;
        int next;
        do {
            current = this.nextServerCyclicCounter.get();
            next = (current + 1) % modulo;
        } while(!this.nextServerCyclicCounter.compareAndSet(current, next));

        return next;
    }
}
```

手写：

```java
package com.atguigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *	自定义负载平衡策略
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

```



### 11.OpenFeign

1.OpenFeign是什么

![image-20210206231647313](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210206231647313.png)

2.OpenFeign能干什么

![image-20210206231856567](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210206231856567.png)

3.Feign和OpenFeign的区别

![image-20210206232102019](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210206232102019.png)

4.OpenFeign的使用：

接口+注解：微服务调用接口+@FeignClient

新建cloud-consumer-feign-order80服务：Feign是用在消费端

pom,yml,主启动

新建Feign接口，来调用生产者的服务：

```java
@Component
@FeignClient(name = "PAYMENT")
public interface PaymentFeignService {
    @GetMapping("provide/info")
    String getPayment(); //注意请求路径和方法定义都要一致!!!
}
```

然后在controller层调用即可。

```注意``` 这里有一个坑，会报：无法找到该服务：PAYMENT

`解决` 问题是出在集群环境下fatchRegister属性必须设置成true才行：

```xml
#是否从EurekaServer抓取自己的注册信息，单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
fetch-registry: true
```

5.OpenFeign的超时控制

openfeign-ribbon客户端默认等待1秒钟，那此时我将在服务端手动阻塞3秒钟会怎样呢？

```java
@GetMapping("provide/info/timeOut")
public String getPaymentTimeOut(){
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return serverPort;
}
```

同理进行调用，报错：

```log
java.net.SocketTimeoutException: Read timed out
```

为了避免这样的情况，我们需要设置Feign客户端的超时控制：

由于Feign是有ribbon进行支持的，所以我们只需要修改ribbon的配置即可：

```xml
#设置feign客户端超时时间(OpenFeign默认支持ribbon)
ribbon:
  #指的是建立连接后，从服务器读取到可用资源所用的时间
  ReadTimeout: 5000
  #指的是建立连接所用的时间，适用于网路环境正常的情况下，两端连接所用的时间
  ConnectTimeout: 5000
```

6.openfeign日志打印功能

日志级别：

- NONE:默认的，不显示任何日志
- BASIC:仅记录请求方法、URL、响应状态码及执行时间
- HEADERS:除了BASIC中定义的信息之外，还有请求和响应的头信息；
- FULL:除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。

配置日志bean

```java
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level getLevel(){
        return Logger.Level.FULL;
    }
}
```

```xml
logging:
  level:
    com.atguigu.springcloud.service.PaymentFeignService: debug
```

### 12.Hystrix断路器 服务降级 (中级部分start)

1.概念：

分布式系统面临的问题

![image-20210217153500426](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217153500426.png)

服务雪崩

![image-20210217153424448](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217153424448.png)

Hystrix是什么:

![image-20210217153735324](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217153735324.png)

Hystrix能干嘛：

- 服务降级
- 服务熔断
- 接近实时的监控
- 。。。。。。

Hystrix怎么用:

官网资料：https://github.com/Netflix/Hystrix/wiki/How-To-Use

2.Hystrix的几个重要概念

服务降级 fallback

服务调不通(程序异常，超时，服务熔断，线程池满等)，返回一个友好的提示。

服务熔断 break

相当于保险丝，当保险丝达到最大服务访问后，直接拒绝访问，拉闸断电，然后调用服务降级返回友好提示。服务降级->进而熔断->恢复调用链路。

服务限流 flowlimit

秒杀高并发等操作，严禁一蜂窝的过来，排队，有序进行。

3.hystrix案例

构建：

新建cloud-provider-hystrix-payment8011

pom.yml,主启动，service,controller，正常的访问和显示。

正常测试没问题，下面进行高并发测试：

用JMeter，进行两万个并发测试时，两个都在转圈圈，甚至卡死(因为tomcat的默认线程数满了)

结论：上面还是服务提供者自己测试，假如此时外部的消费者80也来访问，那消费者只能干等，最终导致消费端80不满意，服务端直接拖死。

下面就新建一个消费者服务来调用服务：cloud-consumer-feign-hystrix-order80

当高并发情况下服务消费者调用生产者服务时就会出现卡顿甚至500情况。故引出服务降级/容错/限流等理论技术诞生。

处理维度分析：

- 对方服务8011超时了，调用者80不能一直卡死等待，必须有服务降级

- 对方服务down机了，调用者80不能一直卡死等待，必须有服务降级。

- 对方服务OK,调用者80自己出故障或有自我要求(自己等待时间小于服务提供者)

4.服务降级处理：@HystrixCommand

- 服务提供者服务降级处理：

  设置自身调用超时时间的峰值，峰值内可以正常运行，超时了/出错了需要有兜底的方法处理，作服务降级fallback

  ```java
  @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
              @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
      })
      public String paymentInfo_TimeOut(Integer id)
      {
          //int age = 10/0;
          try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
          return "线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): 3";
      }
      public String paymentInfo_TimeOutHandler(Integer id)
      {
          return "线程池:  "+Thread.currentThread().getName()+"  8001系统繁忙或者运行报错，请稍后再试,id:  "+id+"\t"+"o(╥﹏╥)o";
      }
  
  //并在主启动类上添加新注解@EnableCircuitBreaker
  ```

- 服务消费者服务降级处理：

  在业务类上添加@HystrixCommand报错后处理与服务提供者类似。

  在服务消费者的主启动类上加上```@EnableHystrix```

全局降级处理```DefaultProperties```

​	问题：每个业务方法对应一个兜底的方法，代码膨胀

​				统一和自定义的分开。

​	解决方法：全局统一的fallback

​	在controller上加入指定默认降级的方法注解：

```java
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
```

​	在下面实现具体的兜底方法

```java
// 下面是全局fallback方法
public String payment_Global_FallbackMethod()
{
    return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
}
```

使用统一的兜底方法就使用```@HystrixCommand```注解，否则具体指定兜底方法。

通用服务降级FeignFallBack

```java
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT" ,fallback = PaymentFallbackService.class)
public interface PaymentHystrixService{
}

@Component
public class PaymentFallbackService implements PaymentHystrixService
{
    @Override
    public String paymentInfo_OK(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}

```

5.服务熔断

断路器

熔断是什么：https://martinfowler.com/bliki/CircuitBreaker.html

![image-20210217221310869](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217221310869.png)

实操

修改cloud-provider-hystrix-payment8011

```java
@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
```

参数解释：

![image-20210217223427628](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217223427628.png)

原理/总结：

![image-20210217223939657](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217223939657.png)

熔断类型：

- 熔断打开：请求不再进行调用当前服务，内部设置时钟一般为MTTR(平均故障处理时间)，当打开时长达到所设置的时钟则进入半熔断状态。
- 熔断关闭：熔断关闭不会对服务进行熔断。
- 熔断半开：部分请求根据规则调用当前服务，如果请求成功且符合规则则认为当前服务恢复正常，关闭熔断。

断路器什么情况开始起作用：

![image-20210217224418034](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217224418034.png)

熔断器关闭条件：

![image-20210217224536768](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217224536768.png)

断路器打开之后：

![image-20210217224600342](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217224600342.png)

所有的配置：

![image-20210217224641586](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217224641586.png)

等等等……

6.服务限流

后面高级篇讲解alibaba的Sentinel时再说明

7.hystrix工作流程：

见官方图例：https://github.com/Netflix/Hystrix/wiki/How-it-Works

8.服务监控hystrixDashboard

新建cloud-consumer-hystrix-dashboard9001监控服务

注意在被监控的服务的主启动类中增加一下代码：

```java
 /**
     *此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
     *ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，
     *只要在自己的项目里配置上下面的servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
```

打开localhost:9001/hystrix然后在请求路径中输入：http://localhost:8011/hystrix.stream 即可实现监控。

![image-20210217231901685](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210217231901685.png)

### 13.zuul

https://github.com/Netflix/zuul/wiki

P65

### 14.gateway

1.gateway是什么？

https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/

![image-20210218232826073](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210218232826073.png)

springCloud gateway使用的WebFlux中的reactor-netty响应式编程组件，底层使用Netty通讯框架。

2.能干什么？

反向代理

鉴权

流量控制

熔断

日志监控

……

微服务架构中网关在哪里？

![image-20210218233059719](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210218233059719.png)

3.gateway非阻塞异步模型

区别

![image-20210218233515278](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210218233515278.png)

特点：



zuul1.x模型

![image-20210218233630089](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210218233630089.png)

缺点：

![image-20210218233716830](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210218233716830.png)

gateway模型 - webflux

![image-20210218233841121](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210218233841121.png)

4.Gateway三大核心概念

- Route（路由）
- Predicate（断言）
- Filter（过滤）

![image-20210218234046736](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210218234046736.png)

![image-20210218234131128](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210218234131128.png)

Gateway工作流程

见上面官网的图。

5.实例搭建z

新建Module：cloud-gateway-gateway9527 pom yml 主启动

在yml中配置网关**网关**

```xml
spring:
  application:
    name: cloud-gateway
  cloud:
    gateway:
      routes:
        - id: payment_routh #payment_route 路由ID 没有固定规则但要求唯一，建议配合服务名
          uri: http://localhost:8001 #匹配后提供服务的路由地址
          predicates:
            - Path=/payment/get/**  # 断言，路径相匹配的进行路由

        - id: payment_routh2 #payment_route 路由ID 没有固定规则但要求唯一，建议配合服务名
          uri: http://localhost:8001
          predicates:
            - Path=/provide/info/**
```

代码的方式配置网关(略)



配置微服务动态路由

```xml
spring:
  application:
    name: cloud-gateway
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
      routes:
        - id: payment_routh #payment_route 路由ID 没有固定规则但要求唯一，建议配合服务名
#          uri: http://localhost:8001 #匹配后提供服务的路由地址
          uri: lb://payment
          predicates:
            - Path=/payment/get/**  # 断言，路径相匹配的进行路由

        - id: payment_routh2 #payment_route 路由ID 没有固定规则但要求唯一，建议配合服务名
#          uri: http://localhost:8001
          uri: lb://payment
          predicates:
            - Path=/provide/info/**
```

hxcbs这些怎么配置出来的？



**predicates**

常用的断言

![image-20210219233323024](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210219233323024.png)

path后面匹配上面的那些，如：

```xml
          predicates:
            - Path=/provide/info/**
            - After=2021-02-19T23:59:07.224+08:00[Asia/Shanghai]
```

这里注意如何获取参数：

时区：

```java
ZonedDateTime now = ZonedDateTime.now();
System.out.println(now);

2021-02-19T23:37:07.224+08:00[Asia/Shanghai]
```

**Filter**

![image-20210219234502192](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210219234502192.png)

常用过滤器的使用：



自定义过滤器：

![image-20210219234922444](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210219234922444.png)