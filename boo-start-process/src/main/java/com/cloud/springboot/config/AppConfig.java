package com.cloud.springboot.config;

import org.springframework.context.annotation.Configuration;

/**
 * @auther: wjx
 * @Date: 2020/12/24 11:00
 * @Description:
 */
@Configuration
public class AppConfig {
    public String name = "app---";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
