package com.example.demo.beans;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import org.springframework.beans.factory.InitializingBean;

public class CustomBean implements InitializingBean  {
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
        LogUtil.print("为age赋值",this.getClass(), LogType.ERROR);
        this.age = age;
    }
    public CustomBean(){
        LogUtil.print("init CustomBean",this.getClass(), LogType.ERROR);
    }

    @Override
    public String toString() {
        return "CustomBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void afterPropertiesSet() {
        LogUtil.print("自定义初始化方法---当前对象为--"+this.toString(),this.getClass(), LogType.ERROR);
    }
}
