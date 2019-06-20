package com.example.demo.beans;

import com.example.demo.util.LogUtil;

public class CustomBean {
    private String name ;
    private int age ;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public CustomBean(){
        LogUtil.error("init CustomBean" , this.getClass());
    }

    @Override
    public String toString() {
        return "CustomBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
