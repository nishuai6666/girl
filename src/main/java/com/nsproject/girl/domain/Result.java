package com.nsproject.girl.domain;

/**
 *
 * 错误对象类
 *
 * */
public class Result<T> {
    /*错误代码.*/
    private Integer code;
    /*错误信息.*/
    private  String message;
    /*具体内容.*/
    private  T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
