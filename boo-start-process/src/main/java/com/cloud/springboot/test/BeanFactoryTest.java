package com.cloud.springboot.test;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @auther: wjx
 * @Date: 2021/1/8 17:38
 * @Description:
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.getBeanNamesIterator();
        beanFactory.getBeanNamesForAnnotation(Service.class);
        beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class);
        beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class,true,true);

        ApplicationContext context = null;


    }
}
