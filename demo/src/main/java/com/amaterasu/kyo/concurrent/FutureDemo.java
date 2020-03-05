package com.amaterasu.kyo.concurrent;

import java.util.concurrent.*;

/**
 * @description: 有关Future机制
 * @author: panchenlei
 * @create: 2020-01-04 22:52
 **/
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureDemo test = new FutureDemo();
        test.futureDemo();
    }

    private void futureDemo() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future = executorService.submit(() -> {
            Thread.sleep(100);
            return 100;
        });
        int i = 0;
        while (!future.isDone()) {
            i++;
            if (i == 13000) {
                System.out.println("cancel:" + future.cancel(true));
            }
            System.out.println("isdone:" + future.isDone());
        }
        System.out.println("return:" + future.get());
    }


}
