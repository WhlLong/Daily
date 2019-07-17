package com.whl.redis.jedis.base;

import com.whl.redis.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈Redis基础结构之Hash〉
 *
 * @author whl
 * @create 2019/7/3
 * @since 1.0.0
 */
public class RedisHash {

    public static void main(String[] args) {

        Jedis jedis = JedisConnectionFactory.newConnection();

        jedis.hset("Books", "Java", "Thinking In Java");
        jedis.hset("Books", "Python", "Thinking In Python");
        jedis.hset("Books", "Golang", "Thinking In Golang");

        Map<String, String> allDataMap = jedis.hgetAll("Books");
        allDataMap.forEach((key, value) -> System.out.println("key=" + key + " value=" + value));

        System.out.println("hlen="+jedis.hlen("Books"));

        System.out.println("Books.Java="+jedis.hget("Books","Java"));

        System.out.println("===============");

        Map<String,String> params = new HashMap<>();
        params.put("C","Learning C");
        params.put("C++","Learning C++");
        params.put("num","6");
        jedis.hmset("Books",params);
        jedis.hgetAll("Books").forEach((key, value) -> System.out.println("key=" + key + " value=" + value));

        jedis.hincrBy("Books","num",10);
        System.out.println("Books.num="+jedis.hget("Books","num"));


        //将连接返回给连接池
        jedis.close();
    }


}