package com.cloud.springboot.processor;

import com.cloud.springboot.service.IndexService;
import com.cloud.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @auther: wjx
 * @Date: 2020/12/24 13:24
 * @Description:
 */
//@Component
@Slf4j
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(IndexService.class);
//        registry.registerBeanDefinition("indexService", rootBeanDefinition);
//        BeanDefinition appConfig = registry.getBeanDefinition("appConfig");
////        registry.removeBeanDefinition("appConfig");
//        appConfig.setBeanClassName("com.cloud.springboot.config.ApplicationConfig");

//        ScannedGenericBeanDefinition rootBeanDefinition = (ScannedGenericBeanDefinition)registry.getBeanDefinition("indexService");
//        rootBeanDefinition.setAutowireMode(1);
//        rootBeanDefinition.setPropertyValues(new MutablePropertyValues(Arrays.asList(new PropertyValue("test","aaa"))));

    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("MyBeanDefinitionRegistryPostProcessor*********postProcessBeanFactory");
        Map<String, Object> map = beanFactory.getBeansWithAnnotation(Service.class);
        Set<String> strings = map.keySet();
//        strings.forEach(System.out::println);


    }
}
