package com.whl.redis.jedis.sentinel;

import com.whl.redis.jedis.JedisSentinelConnectionFactory;
import org.redisson.api.listener.MessageListener;
import org.redisson.client.RedisPubSubListener;
import org.redisson.client.protocol.pubsub.PubSubType;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * 〈Sentinel通知〉
 *
 * @author whl
 * @create 2019/7/17
 * @since 1.0.0
 */
public class SentinelNotify extends JedisPubSub {


    @Override
    public void onMessage(String channel, String message) {
        System.out.println("channel=" + channel + " msg=" + message);
    }
}