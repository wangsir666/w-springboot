package com.cloud.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @auther: wjx
 * @Date: 2020/12/24 15:39
 * @Description:
 */
@Service
public class UserService {

    @Value("'address....'")
    public String address;

    @Autowired
    public IndexService indexService;

    public String name ="user-name..";

    public int age = 11;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public IndexService getIndexService() {
        return indexService;
    }

    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
