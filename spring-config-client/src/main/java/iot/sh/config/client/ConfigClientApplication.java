package iot.sh.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://spring.io/guides/gs/centralized-configuration/
//=======开启actuator检测，调用curl动态刷新配置 单独更新
//http://localhost:8080/actuator
//curl http://localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"
@Slf4j
@SpringBootApplication
public class ConfigClientApplication{
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class,args);
		log.info("============ConfigClient启动完成========");
	}

}

