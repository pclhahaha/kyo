package com.amaterasu.kyo.springdemo.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @description: spring的事件发布订阅机制
 * @author: panchenlei
 * @create: 2020-01-09 10:50
 **/
public class WakeUpEvent extends ApplicationEvent {

    private Boolean isAwake;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public WakeUpEvent(Boolean isAwake) {
        super(isAwake);
        this.isAwake = isAwake;
    }
}
