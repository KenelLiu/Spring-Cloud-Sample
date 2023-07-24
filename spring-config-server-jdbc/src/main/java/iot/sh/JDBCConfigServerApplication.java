package iot.sh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Kenel Liu
 */
@SpringBootApplication
@EnableConfigServer
@Slf4j
public class JDBCConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JDBCConfigServerApplication.class, args);
        log.info("============JDBC ConfigServer 启动完成========");
    }
}
