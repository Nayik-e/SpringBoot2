package com.zyy.controller.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UnifiedDataFormat {
    private Boolean flag;
    private String msg;
    private Object data;

    public UnifiedDataFormat(Boolean flag,Object data,String msg){
        this.data=data;
        this.flag=flag;
        this.msg=msg;
    }

}
