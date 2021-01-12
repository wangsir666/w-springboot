package com.magic.aop.Utils;

import com.alibaba.fastjson.JSON;
import com.magic.aop.Calculator;
import com.magic.aop.MyCalculator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @auther: wjx
 * @Date: 2020/11/15 10:17
 * @Description:
 *     @Before("")
 *     @After()
 *     @AfterReturning
 *     @AfterThrowing
 *     @Around
 */
@Component
@Aspect
@Order(1) //多个切面类执行的优先级顺序，值越小越先
public class LogUtil {



    @Pointcut("execution(* *(..))")
    public void myPointCut(){}

    @AfterReturning(value = "myPointCut()",returning = "re")
    public void all(Object re){
        System.out.println("all.....");
        System.out.println("执行结果是："+re);
    }

    //&& || !
//    @Before("execution(public int com.magic.aop.Lantern.*(int))")
    @AfterReturning(value="execution(public int com.magic.aop.Lantern.getPrice())&&myPointCut()",returning = "r")
    public void lantern(JoinPoint point,Object r){
        System.out.println("before lantern........");
        System.out.println("执行结果:"+r);
    }


//    @After()
//    @AfterReturning
//    @Before
    @Before("execution(public int com.magic.aop.MyCalculator.subtraction(int,int))")
    public static void advice(JoinPoint point){
        System.out.println(Arrays.toString(point.getArgs()));//方法参数
        System.out.println(point.getKind());

        Signature signature = point.getSignature();
        System.out.println(signature.getName()); //方法名称
        System.out.println(signature.getDeclaringTypeName());//执行方法的名 com.magic.aop.Calculator
        System.out.println(signature.toString());//int com.magic.aop.Calculator.subtraction(int,int)
        System.out.println(signature.toLongString());//public abstract int com.magic.aop.Calculator.subtraction(int,int)
        System.out.println(signature.toShortString());//Calculator.subtraction(..)

        System.out.println("******************************");
        System.out.println(point.getThis());
//        MyCalculator c = (MyCalculator)point.getTarget();
//        System.out.println(point.getThis());
//        System.out.println(point.getTarget());

        System.out.println("方法："+"执行before。。");
    }

    // @AfterThrowing
    //@Around
    @AfterThrowing("execution(public int com.magic.aop.MyCalculator.division(int,int))")
    public static void start(){
        System.out.println("方法："+"执行AfterThrowing。。");
    }


}
