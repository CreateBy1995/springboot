package com.example.demo.beans;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import lombok.Data;

@Data
public class MethodBean1 {
    private String name;
    private int age ;
    public MethodBean1(){
        LogUtil.print("init MethodBean1",this.getClass(), LogType.ERROR);
    }
}
