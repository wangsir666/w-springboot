package com.magic.aop;

import org.springframework.stereotype.Service;

/**
 * @auther: wjx
 * @Date: 2020/11/14 20:15
 * @Description:
 */
@Service
public class MyCalculator implements Calculator{
    public String name = "aa";
    @Override
    public int subtraction(int i, int j) {
        System.out.println("subtraction...");
        name ="subtraction";
        return i-j;
    }

    @Override
    public int multiplication(int i, int j) {
        return i*j;
    }

    @Override
    public int division(int i, int j) {
        int result=i/j;
        return result;
    }
}
