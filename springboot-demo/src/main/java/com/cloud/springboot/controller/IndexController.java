package com.cloud.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @auther: wjx
 * @Date: 2020/12/16 21:24
 * @Description:
 */
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {

    Random random = new Random();

    @RequestMapping("/getInfo")
    public String getInfo(){
        System.out.println("getinfo....");
        int number = new Random().nextInt(100);
        return ""+number;
    }

    @GetMapping({"/read1","/read2","/read3"})
    public String read() throws Exception{
        log.info("start---read....");
        Thread.sleep(5000);
        log.info("读结束---end....");
        return random.nextInt(100)+"";
    }
    @GetMapping("/write")
    public String write() throws Exception{
        log.info("write---read....");
        Thread.sleep(5000);
        log.info("写结束--end....");
        return random.nextInt(100)+"";
    }


}
