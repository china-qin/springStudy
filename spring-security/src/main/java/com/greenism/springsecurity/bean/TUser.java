package com.greenism.springsecurity.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user")
public class TUser {
    private Integer id;
    private String username;
    private String password;
    private String role;
}
