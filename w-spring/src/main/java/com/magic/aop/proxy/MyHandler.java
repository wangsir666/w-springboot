package com.magic.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther: wjx
 * @Date: 2020/11/14 21:04
 * @Description:
 */
public class MyHandler implements InvocationHandler {
    private Object obj;
    public MyHandler(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"执行前。。。");
        Object invoke = method.invoke(obj, args);
        System.out.println(method.getName()+"执行后。。。");
        return invoke;
    }
}
