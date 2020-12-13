package com.greenism.springredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringRedisApplicationTests {

	@Autowired
	private StringRedisTemplate redisTemplate;
	@Test
	void contextLoads() {
	}
	@Test
	void redisTest(){
		redisTemplate.opsForValue().set("key","value");
		String key = redisTemplate.opsForValue().get("key");
		System.out.println(key);
		redisTemplate.delete("name");
		redisTemplate.opsForValue().set("key","valueNew");
		key=redisTemplate.opsForValue().get("key");
		System.out.println(key);
	}
}
