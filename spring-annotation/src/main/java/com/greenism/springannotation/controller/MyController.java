package com.greenism.springannotation.controller;

import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;

import com.greenism.springannotation.bean.MyData;
import com.greenism.springannotation.bean.MyParam;

import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@Validated
@RequestMapping("/annotation")
public class MyController {
    @PostMapping("hello")
    public MyData hello(){
        log.info("----------------------hello-------------------------");
        return MyData.builder().data1("data1").data2("data2").data3("data3").build();
    }
    @PostMapping("paramUri/{para1}/{para2}")
    public String paramUri(@PathVariable String para1,@PathVariable String para2){
        log.info("para1:"+para1);
        log.info("para2:"+para2);
        return "param";
    }
    @PostMapping("paramRequest")
    public String paramRequest(@RequestParam("myname") String myname,@PathParam(value="youname") String youname){
        log.info("myname:"+myname);
        log.info("youname:"+youname);
        return "param";
    }
    @RequestMapping("validation")
    public String validation( @RequestBody @Validated MyParam myParam) {

        return "validation";
    }
    @PostMapping("validation1")
    public String validation1( @RequestParam("id") @NotBlank String id) {

        return "validation1";
    }
}
