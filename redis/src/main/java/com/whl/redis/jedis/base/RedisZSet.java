package com.whl.redis.jedis.base;

import com.whl.redis.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * 〈Redis基础结构之ZSet〉
 *
 * @author whl
 * @create 2019/7/3
 * @since 1.0.0
 */
public class RedisZSet {

    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.newConnection();
        jedis.zadd("zBook", 11, "java");
        jedis.zadd("zBook", 13, "c");
        jedis.zadd("zBook", 9, "c++");
        jedis.zadd("zBook", 7, "python");


        Set<String> sets = jedis.zrange("zBook", 0, -1);
/*        sets.forEach(item -> System.out.println(item));

        System.out.println("===========");

        sets = jedis.zrevrange("zBook", 0, -1);
        sets.forEach(item -> System.out.println(item));

        System.out.println("===========");*/


        sets = jedis.zrangeByScore("zBook", 9, 11);
        sets.forEach(item -> System.out.println(item));

        //将连接返回给连接池
        jedis.close();
    }

}