package com.example.demo.beandefinitionregistrypostprocessor;

import com.example.demo.beans.CustomBean;
import com.example.demo.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;


/**
 * 继承BeanDefinitionRegistryPostProcessor这个接口  是用于向beanFactory中动态添加beanDefinition
 * beanDefinition 就是记录一个bean的信息 比如是否单例 是否懒加载等等 后期bean的实例化都是根据beanDefinition记录的信息来进行实例化
 * 正常情况下 都是通过添加@Component 等注解将bean注册到工厂中  也就是注册到 beanFactory 的beanDefinitionMap上
 * 但是实现这个接口的postProcessBeanDefinitionRegistry方法就可以在代码中动态的向beanFactory 添加beanDefinition
 * 由于BeanDefinitionRegistryPostProcessor这个接口继承于BeanFactoryPostProcessor接口  所以也要实现postProcessBeanFactory方法
 * 也是beanFactory的后置处理器
 */
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //  MutablePropertyValues的每一个键值对表示 bean的字段和字段值
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues() ;
        mutablePropertyValues.add("name","Hello") ;
        mutablePropertyValues.add("age",1995) ;
        // 可以在构造beanDefinition的时候就传入mutablePropertyValues
        // 也可通过 beanDefinition.getPropertyValues().add("name","Hello")  增加
        BeanDefinition beanDefinition = new RootBeanDefinition(CustomBean.class,null,mutablePropertyValues) ;
        // 动态注册一个bean
        registry.registerBeanDefinition("customBean",beanDefinition);
        LogUtil.error("CustomBeanDefinitionRegistryPostProcessor  对registry做一些处理",this.getClass());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LogUtil.error("CustomBeanDefinitionRegistryPostProcessor  对beanFactory做一些处理",this.getClass());
    }
}
