package com.magic.ioc.service.impl;

import com.magic.ioc.annoation.WService;
import com.magic.ioc.service.UserService;

/**
 * @auther: wjx
 * @Date: 2020/10/31 16:44
 * @Description:
 */
@WService("userService")
public class UserServiceImpl implements UserService {


    @Override
    public String getNameById(Long id) {
        return "www:"+id;
    }
}
