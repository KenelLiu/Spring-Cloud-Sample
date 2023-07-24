package iot.sh.openfeign.invoke1.service.log.impl;

import iot.sh.config.IConfig;
import iot.sh.openfeign.invoke1.service.log.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = IConfig.Service.ServiceName_Log)
public class LogServiceImpl implements LogService {
    @Override
    public void print(String message) {
        log.info("打印日志:"+message);
    }
}
