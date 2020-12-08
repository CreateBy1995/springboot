package com.example.demo.beanpostprocessor;

import com.example.demo.beans.CustomBean;
import com.example.demo.util.LogType;
import com.example.demo.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor2 implements InstantiationAwareBeanPostProcessor {
    /**
     * 该接口与BeanPostProcessor接口的区别是  本方法会在要实例化的bean的构造方法前被回调
     * 也就是实例化之前
     * @param beanClass
     * @param beanName
     * @return 后置处理器代理返回的bean
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        LogUtil.print("构造方法调用之前 被回调 -----当前类为--"+beanClass.getName(),this.getClass(), LogType.ERROR);
        if("customBean".equals(beanName)){
            return new CustomBean() ;
        }
        return null;
    }

    /**
     * 在bean的属性填充之前会被调用  如果我在此处返回false  则bean不会进行属性填充
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("customBean".equals(beanName)){
            ((CustomBean) bean).setAge(2019);
            return  false ;
        }
        return true;
    }

    /**
     * 在为属性赋值之前被回调
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        LogUtil.print("在对象的属性被赋值前回调----可以在这里修改一些属性",this.getClass(), LogType.ERROR);
        if("customBean".equals(beanName)){
            LogUtil.print("原先的属性age值为---"+pvs.getPropertyValue("age").getValue(),this.getClass(), LogType.ERROR);
           ((MutablePropertyValues)pvs).add("age",2001) ;
            LogUtil.print("将customBean的age属性重新覆盖为2001",this.getClass(), LogType.ERROR);
        }
        return pvs ;
    }
}
