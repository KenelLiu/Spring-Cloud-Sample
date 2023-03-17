spring-config:
    1.spring-config-file
        a.放置配置文件使用git管理
            mkdir spring-config-file
            cd spring-config-file
            git init
        b.在 spring-config-file目录下
            在配置文件spring-config-example.yml增加microservice-one.value=10
            在配置文件spring-config-example-dev.yml增加microservice-one.value=30
    2.spring-config-server
        a.配置spring-cloud-config-server和spring.cloud.config.server
        监听spring-config-file目录下的内容变化
        b.配置spring-cloud-starter-bus-amqp和spring.rabbitmq当配置发生变化时，可通过接口
        调用，将spring-config-file最新内容，通知到配置了spring.rabbitmq所有的spring-config-client
        c.配置spring-boot-starter-actuator和management.endpoints,查看相关spring提供接口 
    3.spring-config-client
        a.配置spring-cloud-starter-config和spring.application.name,spring.profiles.active
        spring.config.import,获取spring-config-server服务上的配置文件
        b.配置spring-cloud-starter-bus-amqp和spring.rabbitmq,spring.cloud.bus 当spring-config-server
        监听到配置发生变化，通过spring-config-server调用接口,可以接收到最新配置内容.

spring cloud config[客户端]动态加载参数测试
    安装rabbit
    docker pull rabbitmq:3-management
    docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management 

    在spring-config-server查看配置：
        /{application}/{profile}[/{label}]
        /{application}-{profile}.yml
        /{label}/{application}-{profile}.yml
        /{application}-{profile}.properties
        /{label}/{application}-{profile}.properties
    注：更新配置spring-config-client里内容,调用spring-config-server的
    curl http://localhost:8888/actuator/busrefresh  -d {} -H "Content-Type: application/json"接口

    example:
        1.启动spring-config-server 8888
        2.启动spring-config-client 8080
        3.调用 http://127.0.0.1:8080/endpoint  查看值
            修改spring-config-example-dev.yml里的值
            curl http://localhost:8888/actuator/busrefresh  -d {} -H "Content-Type: application/json"
            调用 http://127.0.0.1:8080/endpoint  查看值