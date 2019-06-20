package com.example.demo.initializers;

import com.example.demo.beandefinitionregistrypostprocessor.CustomBeanDefinitionRegistryPostProcessor;
import com.example.demo.beanfactorypostprocessor.CustomBeanFactoryPostProcessor;
import com.example.demo.event.CustomEvent;
import com.example.demo.util.LogUtil;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class CustomInitializer implements ApplicationContextInitializer , Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 添加一个自定义的BeanFactoryPostProcessor
        applicationContext.addBeanFactoryPostProcessor(new CustomBeanFactoryPostProcessor());
        // 添加一个自定义的BeanDefinitionRegistryPostProcessor
        applicationContext.addBeanFactoryPostProcessor(new CustomBeanDefinitionRegistryPostProcessor());
        LogUtil.error("自定义 CustomInitializer  在context刷新前添加一个beanFactoryPostProcessor",this.getClass()) ;
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
