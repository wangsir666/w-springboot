package com.magic.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @auther: wjx
 * @Date: 2020/11/15 13:08
 * @Description:
 */
@Service
public class Lantern {

    public int length(){
        System.out.println("length....");
        return 111;
    }

    public int getPrice(){
        System.out.println("get price...");
        return 100;
    }

}
