package com.amaterasu.kyo.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal animal = AnimalProxy.getProxy(cat);
        animal.bark();
        animal.toString();

        CglibAnimalProxy<Cat> proxy = new CglibAnimalProxy<Cat>();
        Cat animal1 = proxy.getInstance(Cat.class);
        animal1.bark();
        animal1.toString();
        animal1.shout();//final方法不被拦截
    }

}
