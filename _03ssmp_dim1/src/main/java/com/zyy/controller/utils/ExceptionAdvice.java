package com.zyy.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public UnifiedDataFormat handleException(Exception e){
        e.printStackTrace();
        return new UnifiedDataFormat(false,null,"服务器内部故障");
    }
}
