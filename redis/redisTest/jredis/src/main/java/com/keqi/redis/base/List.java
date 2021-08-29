package com.keqi.redis.base;

import redis.clients.jedis.Jedis;

public class List {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("1.116.141.79", 6379);

        jedis.flushDB();

        System.out.println("---- 添加一个List -----");
        System.out.println(jedis.lpush("collections", "ArrayList", "Vector", "Stack"));
        System.out.println(jedis.lpush("collections", "HashSet"));
        System.out.println(jedis.lpush("collections", "TreeSet"));
        System.out.println(jedis.lpush("collections", "TreeMap"));
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.lrange("collections", 0, 3));
        System.out.println(" ======================= ");
        // 删除列表指定的值 ，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
        System.out.println(jedis.lrem("collections", 2, "Stack"));
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.ltrim("collections", 0, 3));
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.lpop("collections"));
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.rpush("collections", "EnumMap"));
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.rpop("collections"));
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.lset("collections", 1, "LinkedAL"));
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println("==========================");
        System.out.println(jedis.llen("collections"));
        System.out.println(jedis.lindex("collections", 2));
        System.out.println("=====================");
        System.out.println(jedis.lpush("sortedList", "3", "6", "2", "0"));
        System.out.println(jedis.lrange("sortedList", 0, -1));
        System.out.println(jedis.sort("sortedList"));
        System.out.println(jedis.lrange("sortedList", 0, -1));

    }
}
