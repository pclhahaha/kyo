package com.amaterasu.kyo.lambda;

import com.amaterasu.kyo.proxy.Animal;
import com.sun.javafx.perf.PerformanceTracker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIDemo {

    @Data
    @AllArgsConstructor
    class Pet {
        String name;
    }

    @Data
    @AllArgsConstructor
    class Cat {
        String name;
        String category;
    }

    /**
     * 1. 演示java中List的初始化方法：Arrays.asList  Stream.of().collect()  {{}}双括号方式：匿名内部类+初始化代码块  add方法
     * 2. 演示利用stream API进行集合的转换
     */
    public void streamDemo() {
        List<Cat> cats1 = Arrays.asList(new Cat("lulu", "英短"), new Cat("mimi", "金渐层"));

        List<Cat> cats2 = Stream.of(new Cat("lulu", "英短"), new Cat("mimi", "金渐层")).collect(Collectors.toList());

        List<Pet> animals = cats1.stream().map(e -> new Pet(e.getName())).collect(Collectors.toList());

        List<String> pets = Arrays.asList("cat", "dog", "snake", "squirrel");

        pets.stream();
    }

    public static void main(String[] args) {
    }
}
