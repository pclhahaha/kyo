package com.amaterasu.kyo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {

    /**
     * 线程使用lambda表达式：Runnable接口是函数式接口，可通过lambda表达式创建其实例
     */
    private void threadWithLambda() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":runnable by lambda expression");
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":runnable by anonymous class");
            }
        }).start();
    }

    /**
     * 通过lambda表达式实现自定义的函数式接口(注：JAVA 8 之前一般是用匿名类实现的)
     */
    private void hello() {
        HelloFuncInterface helloFuncInterface = () -> {
            System.out.println("hello");
            return "hello";
        };
        helloFuncInterface.hello();
    }

    /**
     * 方法引用
     */
    private void methodReference() {
        List<String> pets = Arrays.asList("cat", "dog", "snake", "squirrel");
        pets.forEach((a) -> System.out.println(a));//lambda表达式
        pets.forEach(System.out::println);//方法引用

        /**
         * 引用方法
         */
        //对象引用::实例方法名
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello");
        //类名::静态方法名
        Function<Long, Long> abs = Math::abs;
        System.out.println(abs.apply(-3L));
        //类名::实例方法名
        BiPredicate<String, String> b = String::equals;
        System.out.println(b.test("abc", "abcd"));

        /**
         * 引用构造器
         */
        Function<Integer, StringBuffer> stringBufferFunction = StringBuffer::new;
        StringBuffer buffer = stringBufferFunction.apply(10);

        /**
         * 引用数组
         */
        Function<Integer, int[]> fun1 = int[]::new;
        int[] arr = fun1.apply(10);

        Function<Integer, Integer[]> fun2 = Integer[]::new;
        Integer[] arr2 = fun2.apply(10);
    }

    /**
     * lambda表达式加Predicate接口
     */
    private void predicateDemo() {
        List<String> pets = Arrays.asList("cat", "dog", "snake", "squirrel");
        //简单的Predicate接口示例
        pets.stream().filter(s -> s.startsWith("s")).forEach(System.out::println);

        Predicate<String> startWith = s -> s.startsWith("s");
        Predicate<String> lengthPredicate = s -> s.length() > 2;
        //Predicate支持and()操作将两个Predicate接口的逻辑取与
        System.out.println("Predicate and() demo:");
        pets.stream().filter(startWith.and(lengthPredicate)).forEach(System.out::println);
        //Predicate支持or()操作将两个Predicate接口的逻辑取或
        System.out.println("Predicate or() demo:");
        pets.stream().filter(startWith.or(lengthPredicate)).forEach(System.out::println);
        //Predicate支持negate()操作将Predicate接口的逻辑取反
        System.out.println("Predicate negate() demo:");
        pets.stream().filter(startWith.negate()).forEach(System.out::println);
        //Predicate静态方法isEqual()
        System.out.println("Predicate isEqual() demo:");
        pets.stream().filter(Predicate.isEqual("cat")).forEach(System.out::println);
    }

    public static void main(String... args) {
        LambdaDemo demo = new LambdaDemo();

//        demo.threadWithLambda();
//
//        demo.hello();
//
        demo.methodReference();

//        demo.predicateDemo();
    }
}
