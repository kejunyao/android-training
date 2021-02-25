package com.kejunyao.rxjava;

import android.util.Log;
import java.util.concurrent.TimeUnit;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;

/**
 * RxJava过滤操作符
 *
 * @author kejunyao
 * @since 2021年02月14日
 */
public final class RxJavaFilterOperator {

    public static void just() {
        Observable.just("三鹿", "合生元", "飞鹤")
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Throwable {
                        return !"三鹿".equals(s);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Throwable {
                        Log.d(RxJavaActivity.TAG, "accept, s: " + s);
                    }
                });
    }

    public static void take() {
        Observable.interval(2, TimeUnit.SECONDS)
                .take(8) // 只执行8次
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Throwable {
                        Log.d(RxJavaActivity.TAG, "accept, aLong: " + aLong);
                    }
                });
    }

    public static void distinct() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                emitter.onNext(1);
                emitter.onNext(1);
                emitter.onNext(1);
                emitter.onNext(1);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onNext(6);
                emitter.onNext(6);
                emitter.onComplete();
            }
        })
        .distinct() // 过滤重复发射事件
        .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Throwable {
                Log.d(RxJavaActivity.TAG, "accept, integer: " + integer);
            }
        });
    }

    public static void elementAt() {
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("降龙十八掌");
                emitter.onNext("九阴真经");
                emitter.onNext("乾坤大挪移");
                emitter.onNext("玄冥神功");
                emitter.onNext("六脉神剑");
                emitter.onComplete();
            }
        })
        .elementAt(9, "无敌神功")
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                Log.d(RxJavaActivity.TAG, "elementAt, accept, s: " + s);
            }
        });
    }

    public static void fromArray() {
        String[] array = {"A", "B", "C", "D"};
        Observable.fromArray(array)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}