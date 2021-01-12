package com.cloud.springboot.utils;

import java.time.LocalDateTime;

/**
 * @Auther: wjx
 * @Date: 2020/10/26 16:02
 * @Description:
 */
public class ThreadUtil {

    public static String getThreadName(){
        String name = Thread.currentThread().getName();
        return LocalDateTime.now().toString()+name;
    }
}
