# Spring-Cloud-Study
1.安装docker
2.在docker上安装rabbitmq
    docker pull rabbitmq:3-management
    docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
3.启动rabbitmq后
4.启动spring-config-server [测试参数值动态加载 可参看readme-spring-cloud-config.md]
5.启动spring-eureka-server1,spring-eureka-server2
6.启动spring-eureka-service-provider1,spring-eureka-service-provider2
7.启动spring-eureka-openfeign-invoke1,spring-eureka-openfeign-invoke2
8.启动spring-eureka-gateway