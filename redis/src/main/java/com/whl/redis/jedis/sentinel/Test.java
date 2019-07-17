package com.whl.redis.jedis.sentinel;

import com.whl.redis.jedis.JedisSentinelConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/7/17
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        Jedis jedis = JedisSentinelConnectionFactory.newConnection();

        SentinelNotify sentinelNotify = new SentinelNotify();
        jedis.subscribe(sentinelNotify,"+sdown");

    }

}