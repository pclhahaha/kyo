package com.amaterasu.kyo.springdemo.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @description: 事件订阅发布机制
 * @author: panchenlei
 * @create: 2020-01-09 11:23
 **/
public class WakeUpEventPublisherAware implements ApplicationEventPublisherAware {

    ApplicationEventPublisher applicationEventPublisher;

    ApplicationEvent applicationEvent;

    public WakeUpEventPublisherAware(ApplicationEvent applicationEvent) {
        this.applicationEvent = applicationEvent;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish() {
        applicationEventPublisher.publishEvent(applicationEvent);
    }
}
