package com.scjwb.erp.bean;

import java.io.Serializable;

public class Result<T> implements Serializable {

    //额外信息
    private String message;
    //编码
    private String type;
    //数据主体
    private T data;

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setType("success");
        result.setMessage("成功");
        result.setData(data);
        return result;
    }

    public static Result fail(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setType("error");
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
