package com.hxm1.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxm1.mybatisplus.entity.User;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author hxm
 * @date 2020-11-13 10:45
 */
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    void select(){
//        mapper.selectList(null).forEach(System.err::println);
        QueryWrapper wrapper = new QueryWrapper();
        Map<String,Object> map = new HashMap<>();

        map.put("name","hxm");
        map.put("age",1);
//        wrapper.eq("name","hxm");
//        wrapper.select();
//        wrapper.gt("age",1);
//        wrapper.allEq(map);

        //排序加条件查询
//        wrapper.orderByDesc("age");
//        wrapper.having("id > 1");

//        mapper.selectList(wrapper).forEach(System.err::println);

        //以map等值判断
//        System.out.println(mapper.selectByMap(map));

        //以map为结果集返回
//        mapper.selectMaps(wrapper).forEach(System.err::println);
//        System.out.println("+++++++++++++++++++++++++++++");
//        mapper.selectList(wrapper).forEach(System.err::println);

        //分页
//        Page<User> page = new Page<>(2,2);
//        Page<User> result = mapper.selectPage(page, null);
//        System.out.println(result.getSize());
//        System.out.println(result.getTotal());
//        result.getRecords().forEach(System.err::println);

        Page<Map<String,Object>> mapPage = new Page<>(2,3);
        Page<Map<String, Object>> resultMap = mapper.selectMapsPage(mapPage, null);
        resultMap.getRecords().forEach(System.err::println);
    }

    @Test
    void save(){
        User user = new User();
//        user.setId(2L);
        user.setName("kkk");
        user.setAge(8);
        mapper.insert(user);
        System.err.println(user);
    }

    @Test
    void update(){
        /*
        测试乐观锁、通过逻辑设置的、高并发下数据安全
         */
        //查询出来的version=2
        User user1 = mapper.selectById(12);
        user1.setName("mmm");

        //查询出来的version=2
//        User user2 = mapper.selectById(2);
//        user2.setName("二号");

        //执行后update 。。。 version = 3  where version = 2
//        mapper.updateById(user2);

        //此时version=3了，where不通过！！！
        //执行后update 。。。 version = 3  where version = 2
        mapper.updateById(user1);

        System.err.println(user1);
//        System.err.println(user2);
    }
    @Test
    void delete(){
        //1. 删除By id
//        mapper.deleteById(1);
        //2. 删除多行
//        mapper.deleteBatchIds(Arrays.asList(4,5));

        //3. 多条件删除
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("id",4);
//        mapper.delete(wrapper);

        //4. map复合删除 where 1 = ?  and 2 = ?
        Map<String,Object> map = new HashMap<>();
        map.put("id",2);
//        map.put("name","mmm");
        mapper.deleteByMap(map);

    }


    //多表关联查询
    @Test
    void selectProduct(){
        mapper.productList(1).forEach(System.err::println);

    }
}