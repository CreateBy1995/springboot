package com.example.demo.beans;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import lombok.Data;

@Data
public class MethodBean {
    private String name;
    private int age ;
    public MethodBean(){
        LogUtil.print("init MethodBean",this.getClass(), LogType.ERROR);
    }
}
