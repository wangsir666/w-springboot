package com.magic.aop.proxy;

import com.magic.aop.Calculator;
import com.magic.aop.MyCalculator;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static javafx.scene.input.KeyCode.T;

/**
 * @auther: wjx
 * @Date: 2020/11/14 21:07
 * @Description:
 */
public class MyProxy{
    public static Object getCglibProxy(Object obj){
        Enhancer enhancer = new Enhancer();
        //设置被代理的对象
        enhancer.setSuperclass(obj.getClass());
        //设置方法回调
        enhancer.setCallback(new MyMethodInterceptor());
        //获取代理
        return enhancer.create();
    }

    public static Object getProxy1(Object obj){
        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new MyHandler(obj));
        return proxy;
    }
    public static Object getProxy(Object obj){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "执行前。。。");
                Object invoke = method.invoke(obj, args);
                System.out.println(method.getName() + "执行后。。。");
                return invoke;
            }
        };
        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), handler);
        return proxy;
    }


}
