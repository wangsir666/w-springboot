package com.cloud.interview;

/**
 * @auther: wjx
 * @Date: 2020/11/6 10:35
 * @Description:
 */
public class CloneTest {

    public static void main(String[] args) throws Exception{
        Dog d = new Dog();
        d.setName("aaa");
        d.setOwner("bbb");

        Dog dd = d.clone();
        System.out.println(d);
        System.out.println(dd);

//        System.out.println(d==dd);


    }
}
