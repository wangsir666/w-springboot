package com.cloud.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @auther: wjx
 * @Date: 2020/11/5 16:56
 * @Description:
 */
public class MyAwareContext implements BeanNameAware,ApplicationContextAware, EnvironmentAware {
    String name;
    @Override
    public void setBeanName(String name) {
        this.name=name;
    }
    public void test(){
        System.out.println(name);
    }

    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    Environment environment;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


}
