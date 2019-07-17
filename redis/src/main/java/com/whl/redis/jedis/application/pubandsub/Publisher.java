package com.whl.redis.jedis.application.pubandsub;

import com.whl.redis.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/7/8
 * @since 1.0.0
 */
public class Publisher {

    public static void main(String[] args) {

        Jedis jedis = JedisConnectionFactory.newConnection();

        for (int i = 0; i < 100; i++) {
            jedis.publish("publishChannel", "msg:"+i);
        }

    }

}