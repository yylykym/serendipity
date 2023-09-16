package com.akihi.serendipity.umps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class TestController {
    @GetMapping("/res1")
    public String res1(){
        return "服务a-->资源1";
    }

    @GetMapping("/res2")
    public String res2(){
        return "服务a-->资源2";
    }

}
