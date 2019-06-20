package com.example.demo.beanfactorypostprocessor;

import com.example.demo.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor ,Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LogUtil.error("自定义beanFactorypostProcess  对beanFactory做一些处理",this.getClass());
    }
    @Override
    public int getOrder() {
        // 最高优先级
        return HIGHEST_PRECEDENCE;
    }
}
