package com.whl.redis.redisson;

import org.redisson.Redisson;
import org.redisson.RedissonLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/8/27
 * @since 1.0.0
 */
public class DistributedLock {

    public static void main(String[] args) {

        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("http://127.0.0.1:6379");
        singleServerConfig.setDatabase(0);

        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("myLock");
        lock.lock();

        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}