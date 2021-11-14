package com.zyy.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 拦截异常
     * @param e
     * @return
     */
    @ExceptionHandler
    public R handleException(Exception e){
        e.printStackTrace();//将错误输出到控制台
        return new R(false,null,"服务器异常");
    }
}
