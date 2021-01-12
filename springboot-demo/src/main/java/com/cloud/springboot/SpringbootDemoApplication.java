package com.cloud.springboot;

import com.cloud.springboot.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringbootDemoApplication.class);
        ConfigurableApplicationContext context = app.run(args);
//        AppConfig bean = context.getBean(AppConfig.class);
//        System.out.println(bean);
    }
}
