package com.trkj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
public class TestUser {
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //加密操作
    @Test
    public void tset() {
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
}
