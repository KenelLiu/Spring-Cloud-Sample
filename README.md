# Spring-Cloud-Study
1.安装docker
2.在docker上安装rabbitmq
    docker pull rabbitmq:3-management
    docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
	
   如果在云服务上部署需在安全组开通一下端口：15672(UI页面通信口)、5672(client端通信口)、
   25672(server间内部通信口)、61613(stomp 消息传输)、1883(MQTT消息队列遥测传输)。

   docker pull rabbitmq:3-management
   docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
  docker run -d --name rabbit -e RABBITMQ_DEFAULT_USER=stark -e RABBITMQ_DEFAULT_PASS=1990@stark \
	-p 15672:15672 \
	-p 5672:5672 \
	-p 25672:25672 \
	-p 61613:61613 \
	-p 1883:1883  rabbitmq:3-management	
	
3.启动rabbitmq后
4.启动spring-config-server [测试参数值动态加载 可参看readme-spring-cloud-config.md]
5.启动spring-eureka-server1,spring-eureka-server2
6.启动spring-eureka-service-provider1,spring-eureka-service-provider2
7.启动spring-eureka-openfeign-invoke1,spring-eureka-openfeign-invoke2
8.启动spring-eureka-gateway