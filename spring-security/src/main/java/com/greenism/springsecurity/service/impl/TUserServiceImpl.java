package com.greenism.springsecurity.service.impl;

import com.greenism.springsecurity.bean.TUser;
import com.greenism.springsecurity.dao.TUserMapper;
import com.greenism.springsecurity.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TUserServiceImpl implements TUserService {
    @Resource
    TUserMapper tUserMapper;

    @Override
    public List<TUser> getUser(String username) {
        Map<String,Object> para = new HashMap<>();
        para.put("username",username);
        return tUserMapper.selectByMap(para);
    }
}
