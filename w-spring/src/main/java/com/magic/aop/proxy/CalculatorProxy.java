package com.magic.aop.proxy;

import com.magic.aop.Calculator;
import com.magic.aop.MyCalculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther: wjx
 * @Date: 2020/11/14 20:31
 * @Description:
 */
public class CalculatorProxy {

    public static Calculator getCalculator1(MyCalculator calculator){
        Calculator result = (Calculator)Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                new CalculatorHandler(calculator));
        return result;
    }
    /**
     * @author wjx
     * @Description 匿名内部类访问外部的函数，必须要被final修饰,jdk动态代理，被代理的对象必须要实现接口
     * @Date 2020-11-14 20:45:55
     */
    public static Calculator getCalculator(final MyCalculator calculator){

        ClassLoader classLoader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("subtraction")){
                    System.out.println("开始调用减法。。。");
                }
                //开始调用被代理的对象
                Object invoke = method.invoke(calculator, args);
                if(method.getName().equals("subtraction")){
                    System.out.println("减法执行结束。。。");
                }
                return invoke;
            }
        };
        Calculator result = (Calculator)Proxy.newProxyInstance(classLoader, interfaces, handler);
        return result;
    }
}
