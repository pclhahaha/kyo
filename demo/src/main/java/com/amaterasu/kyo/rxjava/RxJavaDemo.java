package com.amaterasu.kyo.rxjava;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-06 19:14
 **/
public class RxJavaDemo {

    public static void main(String[] args) throws InterruptedException {
        RxJavaDemo demo = new RxJavaDemo();
//        demo.hello("pcl", "j");
//        demo.customObservableBlocking().subscribe(s -> System.out.println(s));
//        demo.customObservableNonBlocking().subscribe(s -> System.out.println(s));
//        demo.simpleComposition();

        demo.backPressureOnStart();
    }

    /**
     * hello world
     *
     * @param args
     */
    private void hello(String... args) {
        Flowable.fromArray(args).subscribe(s -> System.out.println("Hello " + s + "!"));
    }

    /**
     * Creating an Observable from an Existing Data Structure
     */
    private void createObservables() {
        Observable<String> o1 = Observable.fromArray(new String[]{"a", "b", "c"});

        Integer[] list = {5, 6, 7, 8};
        Observable<Integer> o2 = Observable.fromArray(list);

        Observable<String> o3 = Observable.just("one object");
    }

    /**
     * This example shows a custom Observable that blocks
     * when subscribed to (does not spawn an extra thread).
     *
     * @return
     */
    private Observable<String> customObservableBlocking() {
        return Observable.<String>create(emitter -> {
            for (int i = 0; i < 50; i++) {
                emitter.onNext("count_" + i);
            }
            emitter.onComplete();
        });
    }

    /**
     * 创建一个非阻塞的Observable
     *
     * @return
     */
    private Observable<String> customObservableNonBlocking() {
        return Observable.<String>create(emitter -> {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        emitter.onNext("count_" + i);
                    }
                    emitter.onComplete();
                }
            }.start();
        });
    }

    /**
     * 用算子对Observable进行组装，或者转变
     */
    private void simpleComposition() {
        customObservableNonBlocking().skip(10).take(5)
                .map(stringValue -> {
                    return stringValue + "_xform";
                })
                .subscribe(s -> System.out.println("onNext => " + s));
    }

    private void backPressure() throws InterruptedException {
        PublishProcessor<Integer> source = PublishProcessor.create();

        source.observeOn(Schedulers.computation(), true, 1024 * 1024)
                .subscribe(v -> {
                    v = v * 2;
                    System.out.println(v);
                }, Throwable::printStackTrace);

        for (int i = 0; i < 1_000_000; i++) {
            source.onNext(i);
        }

        Thread.sleep(10_000);
    }

    private void backPressure1() throws InterruptedException {
        Flowable.range(1, 1_000_000)
                .observeOn(Schedulers.computation())
                .subscribe(v -> {
                    v = v * 2;
                    System.out.println(v);
                }, Throwable::printStackTrace);

        Thread.sleep(10_000);
    }

    private void backPressureInternal() {
        Flowable.range(1, 1_000_000)
                .subscribe(new DisposableSubscriber<Integer>() {
                    @Override
                    public void onStart() {
                        request(1);
                    }
                    public void onNext(Integer v) {
                        v = v * 2;
                        System.out.println(v);
                        request(1);
                    }
                    @Override
                    public void onError(Throwable ex) {
                        ex.printStackTrace();
                    }
                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });
    }

    private void backPressureOnStart() {
        Flowable.range(1, 1_000_000)
                .subscribe(new DisposableSubscriber<Integer>() {

                    String name;

                    @Override
                    public void onStart() {
                        request(1);

                        name = "RangeExample";
                    }

                    @Override
                    public void onNext(Integer v) {
                        System.out.println(name.length() + v);

                        request(1);
                    }

                    @Override
                    public void onError(Throwable ex) {
                        ex.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });
    }
}
