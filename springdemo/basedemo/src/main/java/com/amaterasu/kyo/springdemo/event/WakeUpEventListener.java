package com.amaterasu.kyo.springdemo.event;

import org.springframework.context.ApplicationListener;

import java.time.LocalDateTime;

/**
 * @description: 事件发布订阅
 * @author: panchenlei
 * @create: 2020-01-09 11:22
 **/
public class WakeUpEventListener implements ApplicationListener<WakeUpEvent> {
    @Override
    public void onApplicationEvent(WakeUpEvent event) {
        System.out.println("reveived wakeup event at " + LocalDateTime.now());
    }
}
