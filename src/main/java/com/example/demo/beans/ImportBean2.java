package com.example.demo.beans;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import lombok.Data;

@Data
public class ImportBean2 {
    private String name ;
    private int age ;
    public ImportBean2(){
        LogUtil.print("init ImportBean2",this.getClass(), LogType.ERROR);
    }
}
