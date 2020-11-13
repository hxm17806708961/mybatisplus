package com.hxm1.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxm1.mybatisplus.entity.ProductVO;
import com.hxm1.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hxm
 * @date 2020-11-13 10:42
 */
public interface UserMapper extends BaseMapper<User> {

    //提供的方法不能满足的复合sql
    @Select("SELECT p.*,u.`name` as userName FROM `product` p, `user` u WHERE p.user_id = u.id AND u.id = #{id}")
    List<ProductVO> productList(Integer id);
}
