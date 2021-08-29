package com.keqi.redis.base;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class TestString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("1.116.141.79", 6379);

        jedis.flushDB();
        System.out.println("----增加数据-----");
        System.out.println(jedis.set("key1", "value1"));
        System.out.println(jedis.set("key2","value2"));
        System.out.println(jedis.set("key3", "value3"));
        System.out.println("删除键key2:" + jedis.del("key2"));
        System.out.println("获取键key2:" + jedis.get("key2"));
        System.out.println("修改key1：" + jedis.set("key1", "change1"));
        System.out.println("获取key1：" + jedis.get("key1"));
        System.out.println("在key3后加入值：" + jedis.append("key3", "end"));
        System.out.println("key3:" + jedis.get("key3"));
        System.out.println("增加多个键值对:" + jedis.mset("key01", "value01", "key02", "value02"));
        System.out.println("获取多个键值对:" + jedis.mget("key01","key1"));
        System.out.println("删除多个键值对：" + jedis.del("key01","key02"));
        System.out.println("获取多个键值对：" + jedis.mget("key01", "key02"));





        jedis.flushDB();
        System.out.println("----- 新增键值对防止覆盖原先值------");
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key2", "vn"));
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));

        System.out.println("----  新增键值对设置有效时间 ----");
        System.out.println(jedis.setex("key3", 2, "value3"));
        System.out.println(jedis.get("key3"));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.get("key3"));

        System.out.println("---- 获取原值，更新为新值 ----");
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));

        System.out.println(jedis.getrange("key2",2, 4));
    }

}
