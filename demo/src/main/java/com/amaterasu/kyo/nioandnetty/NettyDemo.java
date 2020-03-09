package com.amaterasu.kyo.nioandnetty;

import io.netty.bootstrap.ServerBootstrap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyDemo {

    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();


    }
}
