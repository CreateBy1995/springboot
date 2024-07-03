package pers.boot.demo.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.StringUtils;

public class SpringUtil   {
    public static ApplicationContext applicationContext ;

    /**
     * 根据名称和类型获取指定的Bean
     * @param name  Bean名称
     * @param requiredType Bean的类型
     * @param <T>  Bean 实例
     * @return
     */
    public static <T> T getBean(String name , Class<T> requiredType){
        if (StringUtils.isEmpty(name)){
            return null ;
        }
        return applicationContext.getBean(name,requiredType) ;
    }

    public static <T> T getBean(Class<T> requiredType){
        return applicationContext.getBean(requiredType) ;
    }

    /**
     * 发布自定义事件
     * @param applicationEvent  自定义事件类型
     */
    public static void publishEvent(ApplicationEvent applicationEvent){
        applicationContext.publishEvent(applicationEvent);
    }
}
