package com.whl.redis.jedis.base;

import com.whl.redis.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 〈Redis基础数据结构之String〉
 *
 * @author whl
 * @create 2019/7/2
 * @since 1.0.0
 */
public class RedisString {

    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = JedisConnectionFactory.newConnection();

        List<String> vals = null;

        jedis.set("key1", "v1");
        jedis.set("key2", "v2");
        jedis.set("key3", "v3");
        jedis.set("key4", "v4");

        System.out.println("key4 exists: " + jedis.exists("key4"));

        jedis.del("key4");
        vals = jedis.mget("key1", "key2", "key3", "key4");
        vals.forEach(item -> System.out.println(item));


        System.out.println("=========");


        jedis.expire("key3", 2);
        Thread.sleep(3 * 1000);
        vals = jedis.mget("key1", "key2", "key3", "key4");
        vals.forEach(item -> System.out.println(item));

        jedis.setex("key5", 2, "v5");
        System.out.println("key5=" + jedis.get("key5"));
        Thread.sleep(3 * 1000);
        System.out.println("key5=" + jedis.get("key5"));

        System.out.println("=========");


        jedis.set("key6", "V6");
        System.out.println("key6=" + jedis.get("key6"));
        Long setNxKey6Result = jedis.setnx("key6", "VAL6");
        System.out.println("setNxKey6Result=" + setNxKey6Result + ", key6=" + jedis.get("key6"));

        jedis.del("key6");
        setNxKey6Result = jedis.setnx("key6", "VAL6");
        System.out.println("setNxKey6Result=" + setNxKey6Result + ", key6=" + jedis.get("key6"));


        jedis.set("number1", "1");
        Long incrResult = jedis.incr("number1");
        System.out.println("incrResult = " + incrResult);

        incrResult = jedis.incrBy("number1",5);
        System.out.println("incrResult = " + incrResult);

        Long decrResult = jedis.decr("number1");
        System.out.println("decrResult = " + decrResult);

         decrResult = jedis.decrBy("number1",2);
        System.out.println("decrResult = " + decrResult);

    }


    private static void print(Jedis jedis) {

    }

}