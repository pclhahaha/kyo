package com.amaterasu.kyo.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @description: CompletableFuture
 * @author: panchenlei
 * @create: 2020-01-04 23:42
 **/
public class CompletableFutureDemo {

    void testGetJoin() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });
        future.get();
//        future.join();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureDemo demo = new CompletableFutureDemo();
        demo.testGetJoin();
    }
}
