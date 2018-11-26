package com.zhongbao.zhongbao.bean;


public class BasicListModel<T> {

    private String code;
    private String message;
    private T list;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BasicModel{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", list=" + list +
                '}';
    }
}
