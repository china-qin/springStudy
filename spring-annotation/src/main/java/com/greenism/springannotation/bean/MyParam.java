package com.greenism.springannotation.bean;


import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MyParam {
    private String para1;
    @NotEmpty
    private String para2;
    private String para3;
}
