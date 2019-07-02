package com.whl.redis.jedis.base;

import com.whl.redis.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 〈Redis基础结构之List〉
 *
 * @author whl
 * @create 2019/7/2
 * @since 1.0.0
 */
public class RedisList {

    public static void main(String[] args) {
        Jedis jedis = JedisConnectionFactory.newConnection();

        //栈   先进后出
        //队列 先进先出


        /**
         * 左边进右边出 =>  队列
         */
        jedis.lpush("list1", "item1", "item2", "item3");
        System.out.println(jedis.rpop("list1"));
        System.out.println(jedis.rpop("list1"));
        System.out.println(jedis.rpop("list1"));
        System.out.println(jedis.rpop("list1"));


        System.out.println("============");

        /**
         * 左边进左边出 =>  栈
         */
        jedis.lpush("list2", "item4", "item5", "item6");
        System.out.println(jedis.lpop("list2"));
        System.out.println(jedis.lpop("list2"));
        System.out.println(jedis.lpop("list2"));
        System.out.println(jedis.lpop("list2"));


        System.out.println("============");

        /**
         * 右边进左边出 r=>  队列
         */
        jedis.rpush("list1", "item1", "item2", "item3");
        System.out.println(jedis.lpop("list1"));
        System.out.println(jedis.lpop("list1"));
        System.out.println(jedis.lpop("list1"));
        System.out.println(jedis.lpop("list1"));


        System.out.println("============");

        /**
         * 右边进右边出 =>  栈
         */
        jedis.rpush("list2", "item4", "item5", "item6");
        System.out.println(jedis.rpop("list2"));
        System.out.println(jedis.rpop("list2"));
        System.out.println(jedis.rpop("list2"));
        System.out.println(jedis.rpop("list2"));

        System.out.println("============");

        jedis.rpush("book", "Math", "English", "Chinese", "Biology");
        //lindex 相当于链表的get(int index)方法  O(n)  慎用
        System.out.println(jedis.lindex("book", 2));

        //lrange 获取范围内的元素, O(n)  慎用   -1表示倒数第一个元素  -2表示倒数第二个元素。。。
        System.out.println(jedis.lrange("book", 0, 2));
        System.out.println(jedis.lrange("book", 0, -1));


        //ltrim   start_index 和 end_index 定义了一个区间，在这个区间内的值要保留，区间之外统统砍掉。慎用
        System.out.println(jedis.ltrim("book", 0, 2));
        System.out.println("llen="+jedis.llen("book"));
    }


}