package com.spring.openfeign.invoke2.service.log;

import com.spring.openfeign.invoke2.service.BaseService;

public interface LogService extends BaseService {
    void print(String message);
}
