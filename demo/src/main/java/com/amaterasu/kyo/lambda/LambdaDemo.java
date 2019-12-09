package com.amaterasu.kyo.lambda;

public class LambdaDemo {

    private void streamWithLambda() {
    }

    //线程使用lambda表达式
    private void threadWithLambda() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":hello");
        }).start();
    }

    public static void main(String... args) {
        LambdaDemo demo = new LambdaDemo();
        System.out.println(Thread.currentThread().getName() + ":hello");
        demo.threadWithLambda();
    }
}
