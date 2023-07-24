package iot.sh.openfeign.invoke2.feign.user;

import iot.sh.constants.IOTConstants;
import iot.sh.entity.User;
import iot.sh.jackson.ObjectMappers;
import iot.sh.response.IOTResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class UserFeignServiceClientFallback implements UserFeignServiceClient {

    @Override
    public String add(String body) {
        IOTResponse response=new IOTResponse();
        try {
            User user = ObjectMappers.JSON_MAPPER.readValue(body.getBytes(StandardCharsets.UTF_8), User.class);
            response.add("user",user);
            response.setStatus(IOTConstants.Response.Status_FAIL);
            response.setMessage("调用UserFeignServiceClient失败");;
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            response.setStatus(IOTConstants.Response.Status_FAIL);
            response.setMessage("调用UserFeignServiceClient 后台发生异常,联系管理员.");
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
