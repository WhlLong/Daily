package com.whl.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/7/2
 * @since 1.0.0
 */
public class JedisConnectionFactory {

    public static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPool = new JedisPool(jedisPoolConfig, "39.105.139.149", 8088, 5000, null);

    }


    public static Jedis newConnection() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
            System.out.println("error:" + e.getMessage());
            e.printStackTrace();
        } finally {

        }

        return jedis;
    }


}