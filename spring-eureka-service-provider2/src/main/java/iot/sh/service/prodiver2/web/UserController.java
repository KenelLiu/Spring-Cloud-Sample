package iot.sh.service.prodiver2.web;

import iot.sh.config.IConfig;
import iot.sh.constants.IOTConstants;
import iot.sh.entity.User;
import iot.sh.jackson.ObjectMappers;
import iot.sh.response.IOTResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;


@Slf4j
@RestController
@RequestMapping(value="/"+IConfig.Module.User)
public class UserController {
    @RequestMapping(path = "/add",method={RequestMethod.POST},produces={"application/json;charset=utf-8"})
    public String query(@RequestBody String body) {
        log.info("eureka service provider2 user add body="+body);
        IOTResponse response=new IOTResponse();
        try {
            User user = ObjectMappers.JSON_MAPPER.readValue(body.getBytes(StandardCharsets.UTF_8), User.class);
            response.add("user",user);
            response.setStatus(IOTConstants.Response.Status_SUCCESS);
            response.setMessage("保存成功");;
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            response.setStatus(IOTConstants.Response.Status_FAIL);
            response.setMessage("后台发生异常,联系管理员.");
        }
        StringWriter stringEmp = new StringWriter();
        try {
            ObjectMappers.JSON_MAPPER.writeValue(stringEmp, response);
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
        }
        return stringEmp.toString();
    }
}
