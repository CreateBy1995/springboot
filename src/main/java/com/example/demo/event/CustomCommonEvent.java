package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class CustomCommonEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomCommonEvent(Object source) {
        super(source);
    }
}
