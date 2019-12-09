package com.amaterasu.kyo.interfacefeature;

public class InterfaceDemo {

    static class DemoInterfaceImpl implements DemoInterface{}


    public static void main(String[] args) {
        new DemoInterfaceImpl().hello();
    }
}
