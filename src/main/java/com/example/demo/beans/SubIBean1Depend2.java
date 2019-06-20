package com.example.demo.beans;

import com.example.demo.util.LogUtil;
import org.springframework.stereotype.Component;

@Component
public class SubIBean1Depend2 {
    public SubIBean1Depend2() {
        LogUtil.error("init SubIBean1Depend2",this.getClass());
    }
}
