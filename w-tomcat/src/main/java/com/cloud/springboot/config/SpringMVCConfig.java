package com.cloud.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Auther: wjx
 * @Date: 2020/10/26 21:25
 * @Description: SpringMVC注解配置，视图解析器
 * WebMvcConfigurerAdapter
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.cloud.springboot.controller"})
public class SpringMVCConfig extends WebMvcConfigurationSupport {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/resources/webapp/WEB-INF/page/");
        viewResolver.setSuffix(".jsp");
        //设置可以在jsp中通过${}访问beans
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }

}
