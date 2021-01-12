package com.cloud.springboot.Listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @auther: wjx
 * @Date: 2021/1/7 13:32
 * @Description:
 */
@WebListener
@Component
public class MyHttpRequestListener implements ServletRequestListener {
    private int count;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        count++;
        System.out.println("ServletRequest++++1");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        count--;
        System.out.println("ServletRequest-----1");
    }
}
