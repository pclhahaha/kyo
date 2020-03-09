package com.amaterasu.kyo.springreactor.reactor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


@RestController
public class BasicController {

    @GetMapping("/hello_world")
    public Mono<String> sayHelloWorld() {
        subscribe();
        return Mono.just("Hello World");
    }

    private void createFluxMono() {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");

        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);

        Mono<String> noData = Mono.empty();

        Mono<String> data = Mono.just("foo");

        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);
    }

    private void subscribe() {
        Flux<Integer> ints1 = Flux.range(1, 3);
        ints1.subscribe(i -> System.out.println(i));

        Flux<Integer> ints2 = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });
        ints2.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error: " + error));

        Flux<Integer> ints3 = Flux.range(1, 4);
        ints3.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"));

        Flux<Integer> ints4 = Flux.range(1, 4);
        ints4.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(2));
    }
}
