package com.cloud.springboot.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @auther: wjx
 * @Date: 2020/12/24 16:18
 * @Description:
 */
@Slf4j
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        if(beanName.equals("indexService")){
//            System.out.println("1-实例化之前--"+beanName);
//        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        if(beanName.equals("indexService")) {
//            System.out.println("2-实例化之后--" + beanName);
//        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//        if(beanName.equals("userEntity")) {
//            System.out.println("3.1-属性注入--" + beanName);
//            PropertyValue pv = pvs.getPropertyValue("name");
//            System.out.println("修改之前："+pv.getValue());
//            pv.setConvertedValue("这是修改之后的值");
//        }
        PropertyValue[] propertyValues = pvs.getPropertyValues();
        for (int i = 0; i < propertyValues.length; i++) {
            System.out.println("3.1-属性注入--" +propertyValues[i]);
        }
        return null;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
//        if(beanName.equals("userService")) {
//            System.out.println("3.2-属性注入--" + beanName);
        /*PropertyValue[] propertyValues = pvs.getPropertyValues();
        for (PropertyValue pv:propertyValues) {
            System.out.println("3-属性注入--"+pv.getName());
        }*/
//        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if(beanName.equals("indexService")) {
//            System.out.println("4-注入容器之前--" + beanName);
//        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if(beanName.equals("indexService")) {
//            System.out.println("5-注入容器之后--" + beanName);
//        }
        return null;
    }
}
