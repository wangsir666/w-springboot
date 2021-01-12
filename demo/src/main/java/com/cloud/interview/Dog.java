package com.cloud.interview;

/**
 * @auther: wjx
 * @Date: 2020/11/6 10:35
 * @Description:
 */
public class Dog implements Cloneable{
    private String name;

    private String owner;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    protected Dog clone() throws CloneNotSupportedException {
        return (Dog) super.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dog{");
        sb.append("name='").append(name).append('\'');
        sb.append(", owner='").append(owner).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
