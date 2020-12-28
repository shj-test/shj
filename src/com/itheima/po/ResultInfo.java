package com.itheima.po;

import java.io.Serializable;

/**
 * 用于封装后端返回前端数据对象
 */
public class ResultInfo implements Serializable {
    private boolean flag;//后端返回结果正常为true，发生异常返回false
    private String msg;//后端返回的提示信息
    private Object data;//后端返回结果数据对象


    //无参构造方法
    public ResultInfo() {
    }

    public ResultInfo(boolean flag) {
        this.flag = flag;
    }

    public ResultInfo(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultInfo(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public ResultInfo(boolean flag, String msg, Object data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
