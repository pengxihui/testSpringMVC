/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月21日下午3:33:04 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.redis.config;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCacheConfig extends CachingConfigurerSupport {

	private volatile JedisConnectionFactory jedisConnectionFactory;
	private volatile RedisTemplate<String, String> redisTemplate;
	private volatile RedisCacheManager redisCacheManager;
	
	public RedisCacheConfig() {
		super();
	}
	
	public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory,RedisTemplate<String,String> redisTemplate,
			RedisCacheManager redisCacheManager) {
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}
	
	public JedisConnectionFactory getJedisConnectionFactory() {
		return jedisConnectionFactory;
	}

	public RedisTemplate<String,String> getRedisTemplate(){
		return redisTemplate;
	}
	
	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}
	
	@Bean
	public KeyGenerator customKeyGenerator() {
		return new KeyGenerator() {
			
			@Override
			public Object generate(Object target, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object object : objects) {
					sb.append(object.toString());
				}
                return sb.toString();
			}
		};
	}
}
  