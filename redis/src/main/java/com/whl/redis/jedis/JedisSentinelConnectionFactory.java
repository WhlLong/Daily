package com.whl.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/7/2
 * @since 1.0.0
 */
public class JedisSentinelConnectionFactory {

    public static JedisSentinelPool jedisSentinelPool;

    static {
        Set<String> sentinels = new HashSet<>(3);
        sentinels.add("192.168.1.131:6379");
        sentinels.add("192.168.1.132:6379");
        sentinels.add("192.168.1.133:6379");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisSentinelPool = new JedisSentinelPool("masterredis",sentinels,jedisPoolConfig,5*1000,5*1000,null,0,"test1");

    }


    public static Jedis newConnection() {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
            System.out.println("error:" + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("===newConnection==");
        }

        return jedis;
    }


}