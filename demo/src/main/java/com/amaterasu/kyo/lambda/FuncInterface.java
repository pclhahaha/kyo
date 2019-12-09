package com.amaterasu.kyo.lambda;

@FunctionalInterface
public interface FuncInterface {

    String hello();

    default String helloWorld() {
        return "hello world";
    }
}
