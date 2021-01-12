package com.cloud.quartz.service;

import org.springframework.stereotype.Service;

/**
 * @auther: wjx
 * @Date: 2020/11/10 14:31
 * @Description:
 */
@Service
public class CrewServiceImpl implements CrewService {
    @Override
    public int getAmount(String groupId) {
        System.out.println("getamount...");
        return Integer.valueOf(groupId)*3;
    }
}
