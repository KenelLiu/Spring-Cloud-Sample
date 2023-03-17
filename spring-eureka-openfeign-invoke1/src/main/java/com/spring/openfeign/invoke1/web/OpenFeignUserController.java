package com.spring.openfeign.invoke1.web;

import com.spring.config.IConfig;
import com.spring.openfeign.invoke1.feign.user.UserFeignServiceClient;
import com.spring.openfeign.invoke1.service.log.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value="/feign/"+IConfig.Module.User)
public class OpenFeignUserController {
    @Autowired
    private LogService logService;
    @Autowired
    private UserFeignServiceClient userFeignServiceClient;

    @RequestMapping(path = "/add",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
    public String query(@RequestBody String body) {
        log.info("openfeign user add body="+body);
        logService.print(body);
        return userFeignServiceClient.add(body);
    }
}
