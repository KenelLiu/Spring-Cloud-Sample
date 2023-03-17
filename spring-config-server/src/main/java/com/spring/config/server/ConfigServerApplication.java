package com.spring.config.server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//=====https://www.baeldung.com/spring-cloud-bus===//
@SpringBootApplication
@EnableConfigServer
@Slf4j
public class ConfigServerApplication{
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class,args);
		log.info("============ConfigServer 启动完成========");
	}

}
