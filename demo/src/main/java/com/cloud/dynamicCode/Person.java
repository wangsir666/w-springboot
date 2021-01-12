package com.cloud.dynamicCode;

/**
 * @auther: wjx
 * @Date: 2020/12/7 14:02
 * @Description:
 */
public class Person {

    private Long id;
    private String name;
    private String address;
    private String email;
    private int age;
    public Person(){}

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Long id, String name, String address, String email, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    public void swim(){
        System.out.println(this.name+" is swimming...");
    }

}
