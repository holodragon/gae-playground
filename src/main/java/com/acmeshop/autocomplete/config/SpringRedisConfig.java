package com.acmeshop.autocomplete.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class SpringRedisConfig {
	@Value("${autocomplete.store.redis.host}")
	private String redisHost;
	@Value("${autocomplete.store.redis.port}")
	private int redisPort;
	@Value("${autocomplete.store.redis.password}")
	private String redisPassword;

	public String getRedisHost() {
		return redisHost;
	}

	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

	public int getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(int redisPort) {
		this.redisPort = redisPort;
	}

	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setHostName(redisHost);
		connectionFactory.setPort(redisPort);
		connectionFactory.setPassword(redisPassword);
		return connectionFactory;
	}

	// @Bean
	// public RedisTemplate<String, Object> redisTemplate() {
	// RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String,
	// Object>();
	// redisTemplate.setConnectionFactory(connectionFactory());
	// redisTemplate.setKeySerializer(new StringRedisSerializer());
	// return redisTemplate;
	// }
	//
	// @Bean
	// public StringRedisTemplate strRedisTemplate() {
	// StringRedisTemplate redisTemplate = new StringRedisTemplate();
	// redisTemplate.setConnectionFactory(connectionFactory());
	// return redisTemplate;
	// }
}