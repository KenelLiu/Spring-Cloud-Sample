package iot.sh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kenel Liu
 */
@RestController
@RefreshScope
@Configuration
@RequestMapping("/api")
public class MainController {
    @Value("${URL_A: default value}")
    private String URL_A;
    @Value("${URL_B: default value}")
    private String URL_B;
    @GetMapping("/configs")
    public Map<String, Object> getConfigData() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("URL_A", URL_A);
        objectMap.put("URL_B", URL_B);
        return objectMap;
    }
}
