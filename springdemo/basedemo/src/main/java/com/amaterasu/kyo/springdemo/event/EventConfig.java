package com.amaterasu.kyo.springdemo.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 事件
 * @author: panchenlei
 * @create: 2020-01-09 13:44
 **/
@Configuration
public class EventConfig {

    @Bean
    public WakeUpEvent wakeUpEvent() {
        return new WakeUpEvent(true);
    }

    @Bean
    public ApplicationListener wakeUpEventListener() {
        return new WakeUpEventListener();
    }

    @Bean
    public ApplicationEventPublisherAware wakeUpEventPublisherAware(ApplicationEvent applicationEvent) {
        return new WakeUpEventPublisherAware(applicationEvent);
    }
}
