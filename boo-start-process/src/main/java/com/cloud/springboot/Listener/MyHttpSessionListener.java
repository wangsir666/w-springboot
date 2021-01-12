package com.cloud.springboot.Listener;

import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @auther: wjx
 * @Date: 2021/1/7 13:32
 * @Description:
 */
@WebListener
@Component
public class MyHttpSessionListener implements HttpSessionListener {
    private int count;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        System.out.println("session++++1");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        System.out.println("session----1");
    }
}
