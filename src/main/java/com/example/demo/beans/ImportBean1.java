package com.example.demo.beans;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

public class ImportBean1 {
    public ImportBean1(){
        LogUtil.print("inti ImportBean1",this.getClass(), LogType.ERROR);
    }
}
