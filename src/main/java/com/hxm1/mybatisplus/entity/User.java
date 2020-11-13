package com.hxm1.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.hxm1.mybatisplus.enums.AgeEnums;
import com.hxm1.mybatisplus.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author hxm
 * @date 2020-11-13 10:31
 */
@Data
public class User {
    @TableId(type = IdType.NONE)
    private Long id;
    private String name;
    private Integer age;

    //不是数据库的字段,不查询该字段
    @TableField(exist = false,select = false)
    private String gender;

//    private Product product;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //乐观锁
    @Version
    private Integer version;

    private StatusEnum status;

    //逻辑删除deleted = 1 ，在yml中配置
    @TableLogic
    private Integer deleted;

}
