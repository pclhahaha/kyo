package com.amaterasu.kyo.springdemo.event;

import com.amaterasu.kyo.springdemo.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-01-09 13:50
 **/
public class WakeUpEventTest extends BaseTest {

    @Resource
    WakeUpEventPublisherAware wakeUpEventPublisherAware;

    @Test
    public void contextLoads() {

        wakeUpEventPublisherAware.publish();
    }

}