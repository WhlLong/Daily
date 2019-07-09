package com.whl.redis.jedis.base;

import com.whl.redis.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * 〈Redis基础结构之Set〉
 *
 * @author whl
 * @create 2019/7/3
 * @since 1.0.0
 */
public class RedisSet {

    public static void main(String[] args) {

        Jedis jedis = JedisConnectionFactory.newConnection();
        Long result = jedis.sadd("sBook", "python");
        System.out.println(result);
        result = jedis.sadd("sBook", "python");
        System.out.println(result);

        jedis.sadd("sBook", "java");
        jedis.sadd("sBook", "go");

        Set<String> sets = jedis.smembers("sBook");
        sets.forEach(item -> System.out.println(item));

        System.out.println(jedis.sismember("sBook","java"));
        System.out.println(jedis.sismember("sBook","golang"));


        System.out.println("scard="+jedis.scard("sBook"));
        System.out.println(jedis.spop("sBook"));


        //将连接返回给连接池
        jedis.close();
    }


}