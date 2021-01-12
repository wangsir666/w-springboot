package com.cloud.springboot.entity;

import org.springframework.context.annotation.Bean;

/**
 * @auther: wjx
 * @Date: 2020/12/24 17:14
 * @Description:
 */
public class UserEntity {

    private Long id;
    private String name;
    private String age;

    public UserEntity(){}
    public UserEntity(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
