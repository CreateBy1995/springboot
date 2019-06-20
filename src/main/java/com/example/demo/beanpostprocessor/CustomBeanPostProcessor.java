package com.example.demo.beanpostprocessor;

import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor ,PriorityOrdered {
    public CustomBeanPostProcessor(){
        LogUtil.print("CustomBeanPostProcessor创建",this.getClass(), LogType.ERROR);
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LogUtil.print("自定义BeanPostProcessor--------------After--------当前Bean为"+beanName,this.getClass(), LogType.ERROR);
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LogUtil.print("自定义BeanPostProcessor--------------Before-------当前Bean为"+beanName,this.getClass(), LogType.ERROR);
        return bean;
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE+2;
    }
}
