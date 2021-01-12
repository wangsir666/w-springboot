package com.magic.ioc;

import com.magic.ioc.context.WApplicationContext;
import com.magic.ioc.service.UserService;

/**
 * @Auther: wjx
 * @Date: 2020/10/31 15:49
 * @Description:
 */
public class IocTest {

    public static void main(String[] args) throws Exception {
        String path = "com.magic.ioc";
        WApplicationContext context = new WApplicationContext(path);
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.getNameById(100L));
    }
}
