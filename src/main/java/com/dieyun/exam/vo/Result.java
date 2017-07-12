package com.dieyun.exam.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4060845259179349523L;

    //1表示成功，0表示失败
    private int flag;

    //提示信息
    private String msg;

    //返回数据
    private T data;

    //状态码
    private int status;

    public Result() {
    }

    public Result(int flag, String msg) {
        this(flag, msg, null);
    }

    public Result(int flag, String msg, T data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public Result(int flag, String msg, T data, int status) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
        this.status = status;
    }

}
