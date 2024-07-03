package pers.boot.demo.event;

import pers.boot.demo.util.LogType;
import pers.boot.demo.util.LogUtil;
import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomEvent(Object source) {
        super(source);
        LogUtil.print("自定义事件CustomEvent",this.getClass(), LogType.ERROR);
    }
}
