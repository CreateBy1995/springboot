package com.example.demo.beans;

import com.example.demo.util.LogUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SubIBean1Depend implements InitializingBean{
    private String name ;
    public SubIBean1Depend() {
        LogUtil.error("init SubIBean1Depend",this.getClass());
    }

    /**
     * 实现此方法后  会在Bean预实例化后被调用 也就是构造方法被调用后  用于自定义一些属性
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "Hello" ;
        LogUtil.error("为SubIBean1Depend的name属性赋值",this.getClass());
    }
}
