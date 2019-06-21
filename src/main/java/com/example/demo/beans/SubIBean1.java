package com.example.demo.beans;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// 存在多个同类型Bean的情况下 优先使用此类型的Bean
@Primary
// 优先加载依赖的Bean
@DependsOn({"subIBean1Depend","subIBean1Depend2"})
public class SubIBean1 implements IBean {
    public SubIBean1() {
        LogUtil.print("init SubIBean1",this.getClass(), LogType.ERROR);
    }
}
