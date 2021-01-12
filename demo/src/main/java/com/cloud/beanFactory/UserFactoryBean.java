package com.cloud.beanFactory;

import com.cloud.entity.User;
import com.cloud.service.impl.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @auther: wjx
 * @Date: 2020/11/5 19:53
 * @Description:
 */
@Component
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setAge(10);
        user.setName("test");
        System.out.println("user.....");
        return user;
    }
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
