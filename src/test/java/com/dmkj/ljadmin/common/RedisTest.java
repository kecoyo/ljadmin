package com.dmkj.ljadmin.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSONObject;
import com.dmkj.ljadmin.common.dto.UserDto;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        String key = "online-token:admin-020ef9f1bdcde85009d0b95210dc8a6e";

        JSONObject admin = (JSONObject) redisTemplate.opsForValue().get(key);
        System.out.println("rs = " + admin.toString());

        redisTemplate.opsForValue().set("userKey", admin);
    }
}
