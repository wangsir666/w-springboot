package com.magic.aop.proxy;

import com.magic.aop.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther: wjx
 * @Date: 2020/11/14 20:59
 * @Description:
 */
public class CalculatorHandler implements InvocationHandler {

    private Calculator calculator;
    public CalculatorHandler(Calculator calculator){
        this.calculator=calculator;
    }
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
}
