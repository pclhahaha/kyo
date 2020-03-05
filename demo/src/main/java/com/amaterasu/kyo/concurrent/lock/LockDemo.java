package com.amaterasu.kyo.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 锁
 * @author: panchenlei
 * @create: 2020-01-11 14:06
 **/
public class LockDemo {

    private final ReentrantLock lock = new ReentrantLock();

    public void lock() {
        lock.lock();  // block until condition holds
        try {
            // ... method body
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
