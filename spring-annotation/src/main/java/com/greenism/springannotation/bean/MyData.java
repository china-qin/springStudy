package com.greenism.springannotation.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyData {
    private String data1;
    private String data2;
    private String data3;
}
