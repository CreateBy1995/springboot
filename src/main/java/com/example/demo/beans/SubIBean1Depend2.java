package com.example.demo.beans;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import org.springframework.stereotype.Component;

@Component
public class SubIBean1Depend2 {
    public SubIBean1Depend2() {
        LogUtil.print("init SubIBean1Depend2",this.getClass(), LogType.ERROR);
    }
}
