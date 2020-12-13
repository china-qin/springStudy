package com.greenism.springsecurity.service;

import com.greenism.springsecurity.bean.TUser;

import java.util.List;

public interface TUserService {
    public List<TUser> getUser(String username);
}
