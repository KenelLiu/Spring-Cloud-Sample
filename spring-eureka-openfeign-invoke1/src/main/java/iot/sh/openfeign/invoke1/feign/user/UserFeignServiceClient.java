package iot.sh.openfeign.invoke1.feign.user;

import iot.sh.config.IConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = IConfig.Eureka.Provider_Service,fallback = UserFeignServiceClientFallback.class)
public interface UserFeignServiceClient {
    //======调用[eureka-service-provider]服务==========//
    @RequestMapping(path="/"+IConfig.Module.User+"/add",method={RequestMethod.POST},
            produces={"application/json;charset=utf-8"})
    public String add(@RequestBody String body);
}
