package com.firelord.component.db.redis;
//TODO:to be implement

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import redis.clients.jedis.JedisPoolConfig;

//@Configuration
//@EnableAutoConfiguration
public class ConfigDBRedis {
//	// #region Construction
//
//	@SuppressWarnings("unused")
//	@Autowired
//	private JedisPoolConfig jedisPoolConfig;
//
//	@Autowired
//	private JedisConnectionFactory jedisConnectionFactory;
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.redis")
//	public JedisPoolConfig jedisPoolConfig() {
//		return new JedisPoolConfig();
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.redis")
//	public JedisConnectionFactory jedisConnectionFactory() {
//		return new JedisConnectionFactory(jedisPoolConfig());
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.redis")
//	public RedisTemplate<String, Object> redisTemplate4DB() {
//		RedisTemplate<String, Object> oRedisTemplate = new RedisTemplate<String, Object>();
//		oRedisTemplate.setConnectionFactory(jedisConnectionFactory);
//
//		// key
//		oRedisTemplate.setKeySerializer(new StringRedisSerializer());
//
//		// // value
//		// Jackson2JsonRedisSerializer<Object> oJackson2JsonRedisSerializer =
//		// new Jackson2JsonRedisSerializer<Object>(
//		// Object.class);
//		// ObjectMapper om = new ObjectMapper();
//		// om.setVisibility(PropertyAccessor.ALL,
//		// JsonAutoDetect.Visibility.ANY);
//		// om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//		// oJackson2JsonRedisSerializer.setObjectMapper(om);
//		// oRedisTemplate.setValueSerializer(oJackson2JsonRedisSerializer);
//		oRedisTemplate.afterPropertiesSet();
//		return oRedisTemplate;
//	}
//
//	// #endregion
}
