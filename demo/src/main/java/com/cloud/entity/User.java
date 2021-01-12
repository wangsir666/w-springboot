package com.cloud.entity;

import com.cloud.ioc.xml.Person;

/**
 * @auther: wjx
 * @Date: 2020/11/5 19:54
 * @Description:
 */
public class User {
    private String name;
    private String passwd;
    private int age;

    public User(){}
    public User(Animal animal){
        System.out.println("animal..");
    }
    public User(Cat cat){
        System.out.println("cat....");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", passwd='").append(passwd).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
