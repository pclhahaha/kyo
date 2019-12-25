package com.amaterasu.kyo.proxy;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnimalProxy {

    public static <T extends Animal> T getProxy(T animal) {
        return (T) Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before invoke");
                System.out.println("proxy:"+proxy.getClass().getName());
                System.out.println("animal class:" + animal.getClass().getName() + "," + animal.getClass().getClassLoader()
                        + "," + JSON.toJSONString(animal.getClass().getInterfaces()));
                Object res = method.invoke(animal, args);
                System.out.println(res);
                System.out.println("after invoke");
                return res;
            }
        });
    }


}
