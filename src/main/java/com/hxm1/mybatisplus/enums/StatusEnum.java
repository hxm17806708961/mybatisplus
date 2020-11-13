package com.hxm1.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author hxm
 * @date 2020-11-13 16:38
 */
public enum StatusEnum {
    WORK(1,"工作状态"),
    REST(0, "休息状态")
    ;

    @EnumValue
    private Integer code;
    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
