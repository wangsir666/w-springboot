package com.cloud.service.impl;

import com.cloud.service.UserService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @auther: wjx
 * @Date: 2020/11/5 16:40
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService, InitializingBean, DisposableBean {
    public UserServiceImpl(){
        System.out.println("UserServiceImpl 构造函数");
    }

    @Override
    public String getUserNameById(Long id) {
        return "userName"+id;
    }

    /** 
     * @author wjx
     * @Description 构造方法先调用，然后再调用该方法
     * @Date 2020-11-05 20:57:29
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("重写InitializingBean接口中的方法afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("重写DisposableBean接口中的方法destroy");
    }
}
