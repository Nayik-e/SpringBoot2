package com.zyy.controller.utils;

import lombok.Data;

//统一表现层的数据接口
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    public R(Boolean flag){
        this.flag=flag;
    }

    public R(Boolean flag,String msg){
        this.flag=flag;
        this.msg=msg;
    }
    public R(Boolean flag,Object data,String msg){
        this.flag=flag;
        this.data=data;
        this.msg=msg;
    }

}
