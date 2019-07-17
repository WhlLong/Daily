package com.whl.redis.jedis.application;

import com.whl.redis.jedis.JedisConnectionFactory;
import jodd.util.RandomString;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.io.IOException;
import java.util.UUID;

/**
 * 〈HyperLogLog〉
 *
 * @author whl
 * @create 2019/7/8
 * @since 1.0.0
 */
public class RedisHyperLogLog {

    public static void main(String[] args) throws IOException {

        Jedis jedis = JedisConnectionFactory.newConnection();

        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 1000; i++) {

            pipeline.multi();
            for (int y = 0; y < 1000; y++) {
                pipeline.pfadd("hyperloglog", UUID.randomUUID().toString());
            }
            pipeline.exec();
        }
        pipeline.close();
        System.out.println(jedis.pfcount("hyperloglog"));

    }

}