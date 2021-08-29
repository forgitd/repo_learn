package com.example.springboot_redis2;


import com.example.springboot_redis2.pojo.User;
import com.example.springboot_redis2.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedis2ApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void test1() {
        redisUtil.set("name", "test9");
        System.out.println(redisUtil.get("name"));
    }

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("k1", "在这");
        System.out.println(redisTemplate.opsForValue().get("k1"));
    }

    @Test
    public void test() throws JsonProcessingException {
        // 导入springboot，
        User user = new User("keqi", 2);
//        String s = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
