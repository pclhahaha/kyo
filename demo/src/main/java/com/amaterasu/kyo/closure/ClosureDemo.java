package com.amaterasu.kyo.closure;

/**
 * @description: 闭包
 * @author: panchenlei
 * @create: 2020-01-08 16:49
 **/
public class ClosureDemo {

    public static void main(String[] args) {

        String a = null;
        String b = a;
        a = "a-1";
        Catcher catcher = new Catcher() {
            @Override
            public void onCatch() {
                System.out.println("catch: " + b);
            }
        };
        catcher.onCatch();
    }

    static class Catcher {

        void onCatch() {
            System.out.println("default catch");
        }
    }

}
