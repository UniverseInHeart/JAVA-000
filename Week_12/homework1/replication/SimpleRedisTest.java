package io.kimmking.cache.test;

import redis.clients.jedis.Jedis;


/**
 *  简单的主从demo
 */
public class SimpleRedisTest {

    public static void main(String[] args) {

		Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.info());
		jedis.set("uptime3", new Long(System.currentTimeMillis()).toString());
		System.out.println(jedis.get("uptime3"));

        Jedis jedis2 = new Jedis("localhost", 6380);
        System.out.println(jedis2.info());
        System.out.println(jedis2.get("uptime3"));
        System.out.println(jedis2.keys("*"));
    }
}
