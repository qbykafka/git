package com.bin.mars.core;

import java.io.Serializable;

public  class Response<T> implements Serializable {


    public Response(){

    }

    /**
     * 成功构造器
     * @param data
     */
    public Response(T data) {
        this.success = true;
        this.data = data;
    }

    /**
     * 失败构造器
     * @param message
     */
    public Response(String message) {
        this.message = message;
    }

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 主要数据
     */
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Response newInstance(T t){
        if (t instanceof String){
           return new Response(String.class.cast(t));
        }
        return new Response(t);
    }

    public static <T> Response newInstance(){
        return new Response();
    }

}
