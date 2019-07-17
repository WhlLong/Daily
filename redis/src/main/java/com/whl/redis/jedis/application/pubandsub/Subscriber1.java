package com.whl.redis.jedis.application.pubandsub;

import com.whl.redis.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * 〈publish and subscribe〉
 *
 * @author whl
 * @create 2019/7/8
 * @since 1.0.0
 */
public class Subscriber1 {

    public static void main(String[] args) {

        Jedis jedis = JedisConnectionFactory.newConnection();

        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("channel:" + channel + " message:" + message);
            }
        }, "publishChannel");

    }

}