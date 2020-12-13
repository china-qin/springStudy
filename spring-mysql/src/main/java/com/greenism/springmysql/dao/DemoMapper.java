package com.greenism.springmysql.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greenism.springmysql.bean.DemoBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper extends BaseMapper<DemoBean> {

}
