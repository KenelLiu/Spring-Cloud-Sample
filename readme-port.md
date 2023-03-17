Cloud configuration 配置中心:
    spring-config-server: 8888 + 监控spring-config-file目录下文件
    示例[spring-config-client]仅用于简单测试配置中心 是否可用,无其他额外作用
    spring-config-client: 8080 + spring-config-file/spring-config-example

Service discovery 服务注册中心:
    spring-eureka-server1: 8761 + spring-config-file/eureka-server1-dev.yml
    spring-eureka-server2: 8762 + spring-config-file/eureka-server2-dev.yml

Provider service  将具体service注册到服务注册中心 
    spring-eureka-service-provider1:8081 + spring-config-file/eureka-service-provider-dev.yml
    spring-eureka-service-provider2:8082 + spring-config-file/eureka-service-provider-dev.yml

Invoke service 将具体service注册到服务注册中心及调用provider service上的服务
    spring-eureka-openfeign-invoke1:8401 + spring-config-file/eureka-openfeign-invoke-dev.yml
    spring-eureka-openfeign-invoke2:8402 + spring-config-file/eureka-openfeign-invoke-dev.yml

Gateway 网关:
    spring-eureka-gateway:80 + spring + spring-config-file/eureka-gateway-dev.yml