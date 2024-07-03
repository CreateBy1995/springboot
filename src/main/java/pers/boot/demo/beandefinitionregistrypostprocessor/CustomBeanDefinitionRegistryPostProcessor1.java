package pers.boot.demo.beandefinitionregistrypostprocessor;

import pers.boot.demo.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanDefinitionRegistryPostProcessor1 implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        LogUtil.error("CustomBeanDefinitionRegistryPostProcessor1  对registry做一些处理",this.getClass());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LogUtil.error("CustomBeanDefinitionRegistryPostProcessor1  对beanFactory做一些处理",this.getClass());
    }
}
