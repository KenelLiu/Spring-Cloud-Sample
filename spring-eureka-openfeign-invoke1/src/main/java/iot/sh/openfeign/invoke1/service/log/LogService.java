package iot.sh.openfeign.invoke1.service.log;

import iot.sh.openfeign.invoke1.service.BaseService;

public interface LogService extends BaseService {
    void print(String message);
}
