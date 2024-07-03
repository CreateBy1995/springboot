package pers.boot.demo.context;

import pers.boot.demo.event.CustomEvent;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

public class CustomContext extends AnnotationConfigServletWebServerApplicationContext {
    @Override
    protected void onRefresh() {
        super.onRefresh();
        // 在这个阶段添加的事件属于early application events事件
        // 这些事件会在refresh()方法中的注册监听器的方法registerListeners()中被发布
        // 但是需要在refresh()方法中的initApplicationEventMulticaster()方法之后才能发布事件，因为此时事件广播器才被初始化
        // 否则在这之前发布自定义事件会抛出异常
        CustomEvent customEvent = new CustomEvent(this) ;
        this.publishEvent(customEvent);
    }
}
