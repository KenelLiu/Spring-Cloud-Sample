package iot.sh.config.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties("microservice-one")
//@ConfigurationProperties(prefix = "upload")
@org.springframework.context.annotation.Configuration
@RefreshScope
public class ClientConfiguration {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
