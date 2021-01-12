package com.cloud.springboot.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;

/**
 * @auther: wjx
 * @Date: 2020/12/24 20:32
 * @Description:
 */
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {

        return null;
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return new Constructor[0];
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return null;
    }
}
