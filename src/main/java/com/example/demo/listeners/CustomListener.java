package com.example.demo.listeners;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;

/**
 * 自定义监听器
 */
public class CustomListener implements GenericApplicationListener {
    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        // 支持的事件 如果支持多个 则用 || 分开
        // 此处表示本监听器监听的事件为ApplicationEnvironmentPreparedEvent 和 ApplicationPreparedEvent
        return eventType.isAssignableFrom(ApplicationEnvironmentPreparedEvent.class)
                || eventType.isAssignableFrom(ApplicationPreparedEvent.class);
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
    }

    /**
     * ApplicationEnvironmentPreparedEvent 事件的监听方法
     * @param event
     */
    public void onApplicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent event){
        System.out.println(" 自定义Listener 监听 ApplicationEnvironmentPreparedEvent 事件");
    }

    /**
     * ApplicationPreparedEvent 事件的监听方法
     * @param event
     */
    public void onApplicationPreparedEvent(ApplicationPreparedEvent event){
        System.out.println(" 自定义Listener 监听 ApplicationPreparedEvent 事件");
    }
}
