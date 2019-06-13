package com.example.demo.initializers;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class CustomInitializer implements ApplicationContextInitializer , Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("自定义 CustomInitializer  在context刷新前做一些操作");
    }

    /**
     * 表明此 Initializer 的执行顺序 值越小优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
