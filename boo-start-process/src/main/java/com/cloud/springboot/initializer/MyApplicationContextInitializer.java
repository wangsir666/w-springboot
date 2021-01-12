package com.cloud.springboot.initializer;

import com.cloud.springboot.controller.IndexController;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @auther: wjx
 * @Date: 2020/12/24 11:06
 * @Description:
 */
@Order(112)
public class MyApplicationContextInitializer implements ApplicationContextInitializer, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("index.desc "+"****:"+applicationContext.getBeanDefinitionCount());
    }

    @Override
    public int getOrder() {
        return 111;
    }
}
