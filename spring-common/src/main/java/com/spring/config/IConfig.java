package com.spring.config;

public interface IConfig {
    //========微服务调用========//
    public interface Eureka{
        //=======[eureka-service-provider1,eureka-service-provider2] 服务提供者名称=======//
        public String Provider_Service="eureka-service-provider";
        //====客户端[eureka-openfeign-invoke1,eureka-openfeign-invoke2]调用[eureka-service-provider1,eureka-service-provider2]上的服务=========//
        public String Invoke_Provider_Service="http://eureka-service-provider/";
    }
    //====功能模块=======//
    public interface  Module{
        public String User="user";
    }

    public interface Service{
        public String ServiceName_User="userService";
        public String ServiceName_Log="logService";
    }
}
