package com.magic.aop.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther: wjx
 * @Date: 2020/11/14 21:38
 * @Description:
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName()+"方法执行前。。。");
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        System.out.println(method.getName()+"方法执行后。。。");
        return invokeSuper;
    }
}
