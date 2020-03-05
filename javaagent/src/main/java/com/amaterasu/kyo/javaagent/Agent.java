package com.amaterasu.kyo.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * @description: java-agent
 * @author: panchenlei
 * @create: 2020-01-06 20:13
 **/
public class Agent {

    /**
     * 以vm参数的方式载入，在Java程序的main方法执行之前执行
     */
    public static void premain(String agentArgs, Instrumentation inst){

    }

    /**
     * 以Attach的方式载入，在Java程序启动后执行
     */
    public static void agentmain(String agentArgs, Instrumentation inst){

    }
}
