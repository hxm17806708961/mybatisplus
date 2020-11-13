package com.hxm1.mybatisplus.entity;

import lombok.Data;

/**
 * @author hxm
 * @date 2020-11-13 15:44
 */
@Data
public class UserVO {
    private Long id;
    private Product productName;
    private String name;
    private Integer age;
}
