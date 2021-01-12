package com.cloud.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wjx
 * @Date: 2020/10/26 14:31
 * @Description:
 */
@RestController
@RequestMapping("")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello....";
    }
}
