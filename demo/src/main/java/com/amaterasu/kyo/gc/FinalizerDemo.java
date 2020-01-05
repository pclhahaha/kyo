package com.amaterasu.kyo.gc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 关于finalize()方法
 * @author: panchenlei
 * @create: 2020-01-04 21:38
 **/
public class FinalizerDemo {

    static AtomicInteger aliveCount = new AtomicInteger(0);

    FinalizerDemo() {
        aliveCount.incrementAndGet();
    }

    @Override
    protected void finalize() throws Throwable {
        FinalizerDemo.aliveCount.decrementAndGet();
    }

    public static void main(String args[]) {
        for (int i = 0; ; i++) {
            FinalizerDemo f = new FinalizerDemo();
            if ((i % 100_000) == 0) {
                System.out.format("After creating %d objects, %d are still alive.%n", new Object[]{i, FinalizerDemo.aliveCount.get()});
            }
        }
    }
}
