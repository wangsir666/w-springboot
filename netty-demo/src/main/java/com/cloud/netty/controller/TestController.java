package com.cloud.netty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: wjx
 * @Date: 2020/11/9 09:50
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public void hello(){
        System.out.println("hello...");
    }

}
