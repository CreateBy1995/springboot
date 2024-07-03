package pers.boot.demo.imports;

import pers.boot.demo.beans.ImportBean2;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportByDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //  MutablePropertyValues的每一个键值对表示 bean的字段和字段值
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues() ;
        mutablePropertyValues.add("name","Hello") ;
        mutablePropertyValues.add("age",1995) ;
        // 可以在构造beanDefinition的时候就传入mutablePropertyValues
        // 也可通过 beanDefinition.getPropertyValues().add("name","Hello")  增加
        BeanDefinition beanDefinition = new RootBeanDefinition(ImportBean2.class,null,mutablePropertyValues) ;
        // 动态注册一个bean
        registry.registerBeanDefinition("importBean2",beanDefinition);
    }
}
