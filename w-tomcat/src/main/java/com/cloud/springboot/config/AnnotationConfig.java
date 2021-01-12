package com.cloud.springboot.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Auther: wjx
 * @Date: 2020/10/26 21:31
 * @Description:
 */
public class AnnotationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Spring上下文配置：从跟目录去获取上下文应用
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringApplicationConfig.class };
    }

    /**
     * SpringMVC配置，本质就是Servlet应用程序上下文的配置
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringMVCConfig.class };
    }

    /**
     * Servlet映射
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
