package com.cloud.springboot.Listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @auther: wjx
 * @Date: 2021/1/7 15:59
 * @Description:
 */
public class PersonInfo implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("添加绑定事件");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解除绑定事件");
    }
}
