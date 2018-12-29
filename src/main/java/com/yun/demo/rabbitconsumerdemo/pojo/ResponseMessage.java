package com.yun.demo.rabbitconsumerdemo.pojo;

import com.yun.demo.rabbitconsumerdemo.constant.ResponseEnum;
import com.yun.demo.rabbitconsumerdemo.constant.ResponseEnum;
import lombok.Data;

@Data
public class ResponseMessage {
    private String code;

    private String desc;

    private Object data;

    public ResponseMessage(ResponseEnum responseEnum, Object data) {
        this.code = responseEnum.getCode();
        this.desc = responseEnum.getDesc();
        this.data = data;
    }

    public ResponseMessage(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.desc = responseEnum.getDesc();
        this.data = null;
    }

    public ResponseMessage(String code, String desc) {
        this.code = code;
        this.desc = desc;
        this.data = null;
    }

    public ResponseMessage(String code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }
}
