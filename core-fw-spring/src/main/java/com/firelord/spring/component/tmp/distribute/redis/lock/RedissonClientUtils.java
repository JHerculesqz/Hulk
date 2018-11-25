package com.firelord.spring.component.tmp.distribute.redis.lock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

public class RedissonClientUtils {
	// #region Fields

	private static RedissonClient redissonClient;

	// #endregion

	// #region Construction

	public RedissonClientUtils() {

	}

	// #endregion

	// #region getRedissonClient

	public static synchronized RedissonClient getRedissonClient() {
		if (null == redissonClient) {
			redissonClient = Redisson.create();
		}
		return redissonClient;
	}

	// #endregion
}
