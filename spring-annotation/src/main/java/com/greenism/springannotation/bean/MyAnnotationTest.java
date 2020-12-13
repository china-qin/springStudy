package com.greenism.springannotation.bean;


import com.greenism.springannotation.annotation.MyAnnotation;

@MyAnnotation(name="name of type")
public class MyAnnotationTest{

    @MyAnnotation(name = "name of method")
    public String hello(){
        return "hello";
    }

}
