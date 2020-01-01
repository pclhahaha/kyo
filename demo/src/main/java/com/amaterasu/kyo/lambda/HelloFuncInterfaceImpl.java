package com.amaterasu.kyo.lambda;

public class HelloFuncInterfaceImpl implements HelloFuncInterface {

    @Override
    public String hello() {
        System.out.println("hello world!");
        return "hello";
    }
}
