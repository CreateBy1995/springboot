package pers.boot.demo.listeners;

import pers.boot.demo.event.CustomCommonEvent;
import pers.boot.demo.event.CustomEvent;
import pers.boot.demo.util.LogUtil;
import pers.boot.demo.util.SpringUtil;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 自定义监听器
 */
public class CustomListener implements GenericApplicationListener , ApplicationContextAware{

    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        // 支持的事件 如果支持多个 则用 || 分开
        // 此处表示本监听器监听的事件为ApplicationEnvironmentPreparedEvent 和 ApplicationPreparedEvent
        // 以及两个自定义的事件
        return eventType.isAssignableFrom(ApplicationEnvironmentPreparedEvent.class)
                || eventType.isAssignableFrom(ApplicationPreparedEvent.class)
                || eventType.isAssignableFrom(CustomEvent.class)
                || eventType.isAssignableFrom(CustomCommonEvent.class);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // SpringBoot 在 事件广播器中统一回调 监听器的 onApplicationEvent 方法
        // 所以需要在此方法中进行对传入事件判断 并且根据传入的事件进行相应的处理
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            onApplicationEnvironmentPreparedEvent(
                    (ApplicationEnvironmentPreparedEvent) event);
        }
        if (event instanceof ApplicationPreparedEvent) {
            onApplicationPreparedEvent((ApplicationPreparedEvent) event);
        }
        if (event instanceof CustomEvent) {
            onCustomEvent((CustomEvent)event);
        }
        if (event instanceof CustomCommonEvent) {
            onCommonCustomEvent((CustomCommonEvent)event);
        }
    }

    /**
     * ApplicationEnvironmentPreparedEvent 事件的监听方法
     * @param event
     */
    public void onApplicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent event){
        // 设置一些必须解析的environment中的参数
        ConfigurableEnvironment environment = event.getEnvironment() ;
        // 在context刷新之前会去验证环境(environment)中是否有这两个参数  如果没有 就会抛出异常
//        environment.setRequiredProperties("time1","time2");
//        LogUtil.error("自定义Listener 监听 ApplicationEnvironmentPreparedEvent 事件",this.getClass());
    }

    /**
     * ApplicationPreparedEvent 事件的监听方法
     * @param event
     */
    public void onApplicationPreparedEvent(ApplicationPreparedEvent event){
//        LogUtil.error("自定义Listener 监听 ApplicationPreparedEvent 事件",this.getClass()) ;
    }
    /**
     * 这个事件是在refresh阶段 为广播器注册监听器的方法中被调用的
     * CustomEvent 事件的监听方法
     * @param event
     */
    public void onCustomEvent(CustomEvent event){
//        LogUtil.error("自定义Listener 监听 CustomEvent applicaion early event 事件",this.getClass()) ;
    }

    /**
     * 监听一般的自定义事件
     * @param event
     */
    public void onCommonCustomEvent(CustomCommonEvent event){
//        LogUtil.error("自定义Listener 监听 onCommonCustomEvent 事件",this.getClass()) ;
    }
    /**
     * 在容器刷新前   SpringBoot会发布contextLoaded事件
     * 在该事件中  所有被通知的监听器如果有实现 ApplicationContextAware 接口
     * 则SpringBoot 会回调该监听器的 setApplicationContext方法
     * 此处用于获取context
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext ;
        LogUtil.error("SpringUtil.applicationContext  赋值成功",this.getClass()) ;
    }
}
