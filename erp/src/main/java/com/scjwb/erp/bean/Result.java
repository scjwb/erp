package com.scjwb.erp.bean;

import java.io.Serializable;

public class Result<T> implements Serializable {
    //是否成功
    private boolean success;
    //额外信息
    private String message;
    //编码
    private String status;
    //数据主体
    private T data;

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setStatus("200");
        result.setMessage("成功");
        result.setData(data);
        return result;
    }

    public static Result fail(String message){
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(message);
        result.setStatus("500");
        return result;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
