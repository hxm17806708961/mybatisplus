package com.hxm1.mybatisplus.entity;

import lombok.Data;

/**
 * @author hxm
 * @date 2020-11-13 15:44
 */
@Data
public class ProductVO {
    private Integer catogory;
    private Integer count;
    private String description;
    private Integer userId;
    private String userName;
}
