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

    void testThenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<Integer> anotherFuture = future.thenCompose(r -> CompletableFuture.supplyAsync(() -> r * 100));
        System.out.println(anotherFuture.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureDemo demo = new CompletableFutureDemo();
        demo.testThenCompose();
    }
}
