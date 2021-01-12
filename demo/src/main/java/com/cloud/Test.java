package com.cloud;

import com.cloud.beanFactory.UserFactoryBean;
import com.cloud.entity.Animal;
import com.cloud.entity.Cat;
import com.cloud.entity.User;
import com.cloud.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: wjx
 * @Date: 2020/11/4 12:22
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws Exception{
//        test1();
//        test2();
        test3();
//        test4();
    }

    private static void test4() {
        User user = new User(new Cat());
        System.out.println(user);
    }

    private static void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(context.getBean("person"));
    }

    private static void test2() {
//        System.out.println(System.getenv());
//        System.out.println("**********");
//        System.out.println(System.getProperties());
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cloud");
        UserService userService = (UserService)context.getBean("userServiceImpl");
//        System.out.println(userService.getUserNameById(11L));
//        context.destroy();
    }

    private static void test1() throws Exception {
        //        ExecutorService threadPool = Executors.newCachedThreadPool();
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cloud");
//        UserService userService = (UserService)context.getBean("userServiceImpl");
//        System.out.println(userService.getUserNameById(11L));
        User user = (User) context.getBean("userFactoryBean");
        System.out.println(user);
        /**
         *  Exception in thread "main" java.lang.ClassCastException:
         *      com.cloud.entity.User cannot be cast to com.cloud.beanFactory.UserFactoryBean
         */
//        UserFactoryBean userFactoryBean = (UserFactoryBean) context.getBean("userFactoryBean");
        //com.cloud.beanFactory.UserFactoryBean@77c2494c
        UserFactoryBean userFactoryBean = (UserFactoryBean) context.getBean("&userFactoryBean");
        System.out.println(userFactoryBean);
        userFactoryBean = (UserFactoryBean) context.getBean("&userFactoryBean");
        System.out.println(userFactoryBean);
    }


}
