package com.amaterasu.kyo.springdemo;

import com.amaterasu.kyo.springdemo.xsddemo.spring.ApplicationConfig;
import com.amaterasu.kyo.springdemo.xsddemo.spring.ServiceBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:config/spring-bean.xml"})
public class ServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServerApplication.class, args);
        ServiceBean serviceBean = context.getBean(ServiceBean.class);
        System.out.println(serviceBean.getName());
        ApplicationConfig applicationConfig = context.getBean(ApplicationConfig.class);
        System.out.println(applicationConfig.getName());
//        NettyServer nettyServer = new NettyServer();
//
//        nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
    }
}
