package com.cloud.springboot.controller.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @auther: wjx
 * @Date: 2020/12/22 13:01
 * @Description:
 */
public class Test1 {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    read();
                    latch.countDown();
                }
            }).start();
        }
        latch.await();

    }

    public static void read(){
        try{
            System.out.println(LocalDateTime.now()+"start ........read...");
            Thread.sleep(5000);
            System.out.println(LocalDateTime.now()+"结束------------read...");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
