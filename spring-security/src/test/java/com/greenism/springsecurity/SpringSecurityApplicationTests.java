package com.greenism.springsecurity;

import com.greenism.springsecurity.bean.TUser;
import com.greenism.springsecurity.dao.TUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringSecurityApplicationTests {
    @Resource
    private TUserMapper tUserMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void generatePwd() {
        String pwd = "test";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encoderPwd = bCryptPasswordEncoder.encode(pwd);
        System.out.println(encoderPwd);
        Boolean result = bCryptPasswordEncoder.matches("admin", encoderPwd);
        System.out.println(result);
    }

    @Test
    void getUser() {
        Map<String, Object> para = new HashMap<>();
        para.put("username", "admin");
        List<TUser> result = tUserMapper.selectByMap(para);
        result.forEach(v -> System.out.println(v.toString()));
    }
}
