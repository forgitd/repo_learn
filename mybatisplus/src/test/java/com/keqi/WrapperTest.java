package com.keqi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.keqi.mapper.UserMapper;
import com.keqi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        // 查询name、邮箱不为空，年龄大于12的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name").isNotNull("email")
                .ge("age",12); //ge 大于
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test2() {
        // 查询名字等于Tom
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Tom");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void test3() {
        // 查询年龄在20-30岁的用户的数量
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);

        System.out.println(userMapper.selectCount(wrapper));
    }

    @Test
    void test4() {
        // 模糊查询，
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 左和右    t%
        wrapper
                .notLike("name","h")
                .likeRight("email","t");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test5() {
        // 子查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id"," select id from user where id <= 3");

        // 这里返回的对象并不是User
        List<Object> list = userMapper.selectObjs(wrapper);
        list.forEach(System.out::println);

    }

    @Test
    void test6() {
        // 排序
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");

        userMapper.selectList(wrapper).forEach(System.out::println);

    }
}
