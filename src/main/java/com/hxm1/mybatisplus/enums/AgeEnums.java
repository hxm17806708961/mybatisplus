package com.hxm1.mybatisplus.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author hxm
 * @date 2020-11-13 16:46
 */
public enum AgeEnums implements IEnum<Integer> {
    ONE(1, "一岁"),
    TWO(2, "两岁"),
    THREE(3, "三岁");

    AgeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
