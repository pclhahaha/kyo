package com.amaterasu.springdemo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        NettyServer nettyServer = new NettyServer();

        nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
    }
}
