package com.greenism.springsecurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greenism.springsecurity.bean.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

}
