package iot.sh.openfeign.invoke2.service.log;

import iot.sh.openfeign.invoke2.service.BaseService;

public interface LogService extends BaseService {
    void print(String message);
}
