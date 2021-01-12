package com.cloud.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: wjx
 * @Date: 2020/10/26 21:35
 * @Description:
 */
@Controller
@RequestMapping("")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
