package com.cloud.springboot.initializer;

import com.cloud.springboot.controller.IndexController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @auther: wjx
 * @Date: 2020/12/24 11:06
 * @Description:
 */
@Slf4j
@Order(111)
public class MyApplicationContextInitializer1 implements ApplicationContextInitializer, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
//        IndexController index = applicationContext.getBean(IndexController.class);
        System.out.println("aaaaaaaaaaaaaaa1111111");
    }

    @Override
    public int getOrder() {
        return 111;
    }
}
