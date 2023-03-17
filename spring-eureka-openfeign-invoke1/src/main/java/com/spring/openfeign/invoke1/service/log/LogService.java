package com.spring.openfeign.invoke1.service.log;

import com.spring.openfeign.invoke1.service.BaseService;

public interface LogService extends BaseService {
    void print(String message);
}
