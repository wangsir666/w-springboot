package com.cloud.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: wjx
 * @Date: 2020/12/24 15:24
 * @Description:
 */
@Slf4j
@Service
public class IndexService {

    public String getIndexInfo(){
        log.info("getIndexInfo....");
        return "getIndexInfo";
    }

}
