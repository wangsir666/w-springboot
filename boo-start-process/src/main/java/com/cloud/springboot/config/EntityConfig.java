package com.cloud.springboot.config;

import com.cloud.springboot.entity.UserEntity;
import com.cloud.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: wjx
 * @Date: 2020/12/24 17:18
 * @Description:
 */
@Configuration
public class EntityConfig {

    @Autowired
    private UserService userService;
    @Bean
    public UserEntity userEntity(){
        UserEntity user = new UserEntity();
        return user;
    }
}
