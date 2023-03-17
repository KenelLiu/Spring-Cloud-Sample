配置统一管理:
    Spring Cloud Config:Spring开发的配置服务，可以从github、支持JDBC的数据库或者其他文件系统中拉取配置
    Nacos ：nacos除了有注册中心的功能之外，还可以提供配置管理服务。

微服务网关框架：
    Spring Cloud GateWay ：Spring Cloud开发，在SpringMvc上构建的API网关框架。
    Zuul : 由Netflix公司开发，采用servlet的同步阻塞架构 已经进入维护状态了。
    Zuul2 : Zuul2采用异步非阻塞架构,Zuul2和Zuul1在架构方面的主要区别在于Zuul2运行在异步非阻塞的框架Netty上。Zuul1依赖多线程来支持吞吐量的增长，
            而Zuul2使用的Netty框架依赖事件循环和回调函数
    Tesla gateway:采用如消息驱动的方式向下流转，每一个功能由具体的handler进行处理，处理完成后，
            发送到后续的pipe，供其他handler处理，类似于过滤器，handler是gateway抽象出的承载业务处理的扩展点，
            gateway内置的诸多功能即实现handler扩展而来的，针对项目组的特殊需求可考虑扩展handler很简单的集成
            到gateway中。同时针对现有功能，也提供handler更细粒度的前置和后置过滤器。

微服务的注册与发现:
    Netflix Eureka :spring cloud官网推荐　　
    Consul 
    Zookeeper
    Nacos:阿里开发的开源框架

微服务调用:
    Feign ：内集成了Ribbon，可以通过注解，像本地调用似的跨域调用微服务接口
    OpenFeign ：Spring Cloud在Feign的基础上，支持了SpringMvc的注解
    Ribbon : 一个客户端负载均衡的工具，由Netflix公司开发，已经进入了维护状态，不再进行新的功能开发。

服务的限流、降级、熔断:
    Resilience4j：spring cloud官网推荐　　
    sentinel : 阿里开发的开源框架，提供可视化界面，多语言支持的服务熔断降级限流框架
    Hystrix : 由Netflix公司开发的一个进行服务熔断、降级的框架，进入维护状态

分布式事务：
    Seata

分布式跟踪:
    Spring Cloud Sleuth+Zipkin

JWT(JSON Web Token)
JWT is a standard that defines a compact and secure way of transmitting data along 
with a signature between two parties. The payload within a JWT is a JSON object 
that asserts some claims. This payload can be easily verified and trusted by the verifier
as it's digitally signed. JWTs can be signed using either a secret key or a public/private key pair.

JWT的构成
A JWT basically consists of three parts:
    1.Header 内容如下:
        {
        "alg": "HS256", //算法 HMAC, RSA, and ECDSA
        "typ": "JWT"
        }
        The above header object is then Base64-encoded to form the first part of the JWT.

    2.Payload
        The JWT Payload contains a set of claims.
        There are three types of claims:
            I.Registered:标准中注册的声明 (建议但不强制使用):
                iss: jwt签发者
                sub: jwt所面向的用户
                aud: 接收jwt的一方
                exp: jwt的过期时间，这个过期时间必须要大于签发时间
                nbf: 定义在什么时间之前，该jwt都是不可用的.
                iat: jwt的签发时间
                jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
            II.Public:
                These can be defined at will by those using JWTs.
                公共的声明可以添加任何的信息，一般添加用户的相关信息或其他业务需要的必要信息
            III.Private:
                We can use these claims to create custom claims.  
                私有声明是提供者和消费者所共同定义的声明
        payload sample:
        {
        "sub": "Baeldung Details",
        "nbf": 1669463994,
        "iss": "Baeldung",
        "exp": 1669463998,
        "userId": "1234",
        "iat": 1669463993,
        "jti": "b44bd6c6-f128-4415-8458-6d8b4bc98e4a"
        }
    Here, we can see that the Payload contains a private claim userId denoting the logged-in user's ID. Also, 
    we can find some other useful restricted claims that define additional details about the JWT.

    The JWT Payload is then Base64-encoded to form the second part of the JWT.
    
3.Signature
    Lastly, the JWT Signature is generated when we sign the encoded header 
    and encoded payload using a signing algorithm with a secret key.
    https://www.baeldung.com/java-auth0-jwt

参考资料:
https://spring.io/projects/spring-cloud
https://spring.io/guides/
https://www.baeldung.com/
https://blog.knoldus.com/spring-cloud-api-gateway/
https://www.logicbig.com/tutorials/spring-framework/spring-core/creating-and-publishing-custom-events.html
http://tndavidson.logdown.com/posts/1753021