# Spring Boot 整合 Dubbo 与 Zookeeper

## Dubbo

[Apache Dubbo](http://dubbo.apache.org/zh/)

## Zookeeper

### 服务端

[官网](https://zookeeper.apache.org/)

### 客户端

- Zookeeper原生
- [Curator](http://curator.apache.org/)
- [ZkClient](https://github.com/sgroschupf/zkclient)

## 引入依赖

```xml
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>2.7.8</version>
</dependency>
    <dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-recipes</artifactId>
    <version>5.1.0</version>
</dependency>
```

参考[官方样例](https://github.com/apache/dubbo-spring-boot-project/tree/master/dubbo-spring-boot-samples/auto-configure-samples)

使用pom引入[共同的服务](https://github.com/apache/dubbo-spring-boot-project/tree/master/dubbo-spring-boot-samples/sample-api)
