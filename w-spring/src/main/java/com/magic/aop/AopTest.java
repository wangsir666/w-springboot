package com.magic.aop;

import com.magic.aop.proxy.CalculatorProxy;
import com.magic.aop.proxy.MyHandler;
import com.magic.aop.proxy.MyMethodInterceptor;
import com.magic.aop.proxy.MyProxy;
import net.sf.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wjx
 * @Description aop测试使用类
 * @Date 2020-10-31 16:30:30
 */
public class AopTest {
    static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();
    }

    private static void test7() {
        Lantern lantern = context.getBean(Lantern.class);
        lantern.length();

    }

    private static void test6() {
        Calculator bean = context.getBean(Calculator.class);
        System.out.println(bean.division(10, 2));
        //bean = context.getBean(MyCalculator.class);//error,注入的是接口的class
//        Calculator calculator = (Calculator)context.getBean("myCalculator");
//        System.out.println(calculator.division(20, 0));
    }
    private static void test5() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator calculator = (Calculator)context.getBean("myCalculator");
        System.out.println(calculator.subtraction(20, 1));

    }

    private static void test4() {
        Calculator calculator = (Calculator) MyProxy.getCglibProxy(new MyCalculator());
        System.out.println(calculator.subtraction(10, 3));
    }

    private static void test3() {
        //通过cglib获取动态代理
        Enhancer enhancer = new Enhancer();
        //设置被代理的对象
        enhancer.setSuperclass(MyCalculator.class);
        //设置方法回调
        enhancer.setCallback(new MyMethodInterceptor());
        //获取代理
        Calculator calculator = (Calculator) enhancer.create();
        System.out.println(calculator.subtraction(10, 3));
    }

    private static void test2() {
//        Calculator proxy =  (Calculator)MyProxy.getProxy(new MyCalculator());
        Calculator proxy =  (Calculator)MyProxy.getProxy1(new MyCalculator());
        System.out.println(proxy.subtraction(10, 3));

    }

    private static void test1() {
//        Calculator calculator = CalculatorProxy.getCalculator(new MyCalculator());
        Calculator calculator = CalculatorProxy.getCalculator1(new MyCalculator());
        System.out.println(calculator.subtraction(10, 3));
    }


}
