package com.amaterasu.kyo.proxy;

//final  final类无法被cglib加强，因为cglib是基于继承实现动态代理，final的类无法被继承
public class Cat implements Animal, Pet {
    @Override
    public String bark() {
        return "meow";
    }

    @Override
    public String toString() {
        return "meow";
    }

    final void shout() {
        System.out.println("meow!!!");
    }
}
