package com.greenism.springmysql.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName(value = "t_demo")
public class DemoBean {
    private Integer id;
    private String name;
    private String value;
}