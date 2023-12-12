package com.dmkj.ljadmin.common;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.dmkj.ljadmin.common.utils.JwtUtils;

public class JwtUtilsTest {

    @Test
    void testGenerateToken() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("username", "admin");
        String token = JwtUtils.generateToken(map, "your-secret-key");
        System.out.println(token);
    }
}
