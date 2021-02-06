package redis.lettuce;

import org.redisson.client.RedisClient;

public class LettuceSentinelTest {

    public static void main(String[] args) {

        //基于Lettuce 简单的demo start
		RedisClient redisClient = RedisClient.create("redis://@localhost:6379");
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		syncCommands.set("key", "Hello, Redis!");

		System.out.println(syncCommands.get("key"));

		connection.close();
		redisClient.shutdown();
        // end

        //基于Lettuce sentinel start
		RedisClient redisClient = RedisClient.create("redis-sentinel://localhost:26379,localhost:26380/0#mymaster");

		StatefulRedisConnection<String, String> connection = redisClient.connect();

		System.out.println("Connected to Redis using Redis Sentinel");

		connection.close();
		redisClient.shutdown();
    }
}
