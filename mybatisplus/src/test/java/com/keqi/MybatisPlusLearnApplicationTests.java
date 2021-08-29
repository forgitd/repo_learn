package com.keqi;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.mapper.UserMapper;
import com.keqi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusLearnApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        // 这里的参数Wrapper 是条件构造器
        List<User> userList = userMapper.selectList(null);
        // 语法糖
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(17);
        user.setEmail("hmmlllh@qqq.com");
        user.setName("mmnm");

        int insert = userMapper.insert(user); // 使用雪花算法自动生成主键

        System.out.println(insert); // 返回1
        System.out.println(user);   // 返回使用雪花算法自动生成的主键

    }

    @Test
    public void testUpdate() {

        User user = new User();
        user.setId(4L);
        user.setName("hh");

        // 这里的参数是一个对象
        int i = userMapper.updateById(user);  // 可以通过条件自动拼接sql
        System.out.println(i);  // 返回1
    }

    @Test
    public void testVersion1() {
        User user = userMapper.selectById(1L);
        user.setName("keqi");
        user.setEmail("forgitfff@outlook.com");

        userMapper.updateById(user);
    }

    @Test
    public void testVersion2() {
        User user = userMapper.selectById(1L);
        user.setName("keqi1111");
        user.setEmail("forgitfff@outlook.com");

        User user2 = userMapper.selectById(1L);
        user2.setName("keqi2222");
        user2.setEmail("forgitfff@outlook.com");
        userMapper.updateById(user2);

        userMapper.updateById(user);
    }


    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectByBatchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByBatchIds() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","keqi");

        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);

    }

    // 分页插件
    @Test
    public void testPage() {
        // 第一个参数：当前页
        // 第二个参数：页面大小
        Page<User> page = new Page<>(2, 4);
        // 应该是参数作为返回值
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(1L);
    }

    @Test
    public void testDeleteByBatchId() {
        userMapper.deleteBatchIds(Arrays.asList(1420560613830561798L,1420560613830561797L));
    }

    @Test
    public void testDeleteMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","keqi");
        userMapper.deleteByMap(map);
    }
}
