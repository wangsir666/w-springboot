package com.cloud.springboot.processor;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @auther: wjx
 * @Date: 2020/12/24 20:46
 * @Description:
 */
//@Component
public class MyAbstractAutoProxyCreator extends AbstractAutoProxyCreator {
    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {
        return new Object[0];
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) {
        return super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) {
        return super.getEarlyBeanReference(bean, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) {
        return super.determineCandidateConstructors(beanClass, beanName);
    }
}
