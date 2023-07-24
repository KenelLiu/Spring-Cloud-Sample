package iot.sh.openfeign.invoke1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableDiscoveryClient  // 发现服务
@EnableFeignClients
@SpringBootApplication
public class EurekaOpenFeignInvoke {
    public static void main(String[] args) {
        SpringApplication.run(EurekaOpenFeignInvoke.class, args);
        log.info("============EurekaOpenFeignInvoke 1 启动完成========");
    }
}
