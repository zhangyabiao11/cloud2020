package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *  通用返回实体类
 * </p>
 *
 * @author: zhangyb
 * @create: 2020-11-16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
    public CommonResult(String message){
        this(0,message,null);
    }
    public CommonResult(String message,T data){
        this(1,message,data);
    }
}
