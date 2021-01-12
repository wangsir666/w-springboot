package com.cloud.springboot;

import com.cloud.springboot.config.AppConfig;
import com.cloud.springboot.config.ApplicationConfig;
import com.cloud.springboot.initializer.MyApplicationContextInitializer;
import com.cloud.springboot.initializer.MyApplicationContextInitializer1;
import com.cloud.springboot.service.IndexService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @auther: wjx
 * @Date: 2020/12/24 10:59
 * @Description:
 */
@SpringBootApplication
public class BootStartProcessApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BootStartProcessApplication.class);
        app.run(args);
//        app.addInitializers(new MyApplicationContextInitializer());
//        app.addInitializers(new MyApplicationContextInitializer1());
//        ConfigurableApplicationContext context = app.run(args);
//        IndexService indexService = (IndexService) context.getBean("indexService");
//        System.out.println(indexService.getIndexInfo());
//        AppConfig appConfig = (AppConfig)context.getBean("appConfig");
//        System.out.println(appConfig.name);
//        Executors.newScheduledThreadPool(1);
//        Executors.newFixedThreadPool(1);
//        Executors.newCachedThreadPool();
//        Executors.newSingleThreadExecutor();

    }
}
