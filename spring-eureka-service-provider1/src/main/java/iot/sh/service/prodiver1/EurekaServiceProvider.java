package iot.sh.service.prodiver1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceProvider {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceProvider.class, args);
        log.info("============EurekaServiceProvider 1 启动完成========");
    }
}
