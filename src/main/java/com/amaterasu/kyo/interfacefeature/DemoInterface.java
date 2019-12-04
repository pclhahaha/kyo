package com.amaterasu.kyo.interfacefeature;

public interface DemoInterface {

    int code = 0;
    String msg = "hello";

    default void hello(){
        System.out.println(msg);
    }

}
