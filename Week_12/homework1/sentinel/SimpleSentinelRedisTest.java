package io.kimmking.cache.test;

import com.alibaba.fastjson.JSON;
import io.kimmking.cache.sentinel.SentinelJedis;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class SimpleSentinelRedisTest {

    public static void main(String[] args) {
        // C2.基于sentinel和连接池的demo
        Jedis sjedis = SentinelJedis.getJedis();
        System.out.println(sjedis.info());
        sjedis.set("uptime2", new Long(System.currentTimeMillis()).toString());
        System.out.println(sjedis.get("uptime2"));
        System.out.println(sjedis.keys("*"));
        SentinelJedis.close();
    }
}
