package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        //publisher
        Mono<String> mono = Mono.just("ball");
        mono.subscribe(
                item -> System.out.println("item"),
                err-> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
        //public final reactor.core.Disposable subscribe(@reactor.util.annotation.Nullable java.util.function.Consumer<? super T> consumer, @reactor.util.annotation.Nullable java.util.function.Consumer<? super java.lang.Throwable> errorConsumer, @reactor.util.annotation.Nullable java.lang.Runnable completeConsumer) { /* compiled code */ }

        //refactoring
        Mono<Integer> monoRefacotirng = Mono.just("ball")
                                            .map(String::length)
                                            .map(l -> l / 0);
        monoRefacotirng.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
