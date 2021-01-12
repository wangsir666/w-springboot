package com.cloud.springboot.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @auther: wjx
 * @Date: 2020/12/23 16:32
 * @Description:
 */
@Configuration
@PropertySource("classpath:dev-temp.properties")
@ConfigurationProperties(prefix = "app.temp")
@ToString
@Data
public class AppConfig {
    private String name;
    private String age;
    private Integer id;
}
