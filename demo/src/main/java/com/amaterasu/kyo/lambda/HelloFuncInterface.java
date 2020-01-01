package com.amaterasu.kyo.lambda;

@FunctionalInterface
public interface HelloFuncInterface {

    String hello();

    default String helloWorld() {
        return "hello world";
    }

    static void printHello() {
        System.out.println("Hello");
    }
}
