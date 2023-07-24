package iot.sh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Kenel Liu
 */
@Slf4j
@SpringBootApplication
public class JDBCConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(JDBCConfigClientApplication.class, args);
        log.info("============JDBC ConfigClient启动完成========");
    }
}