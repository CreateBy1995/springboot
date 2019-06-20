package com.example.demo.beans;

import com.example.demo.util.LogUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SubIBean2 implements IBean {
    public SubIBean2() {
        LogUtil.error("init SubIBean2",this.getClass());
    }
}
