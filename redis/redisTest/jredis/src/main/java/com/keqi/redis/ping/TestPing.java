package com.keqi.redis.ping;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("1.116.141.79",6379);

        System.out.println(jedis.ping());
    }
}
