package com.kejunyao.test;

import android.os.SystemClock;
import android.util.Log;

import com.kejunyao.base.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年03月04日
 */
public class TestSolution implements Solution {

    Queue<String> queue = new LinkedList<>();

    private void producerAndConsumer() {
        for (int i = 1; i <= 2; i++) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        product();
                        SystemClock.sleep(1000);
                    }
                }
            });
            th.setName("producer-" + i);
            th.start();
        }
        for (int i = 2; i <= 3; i++) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        consumer();
                        SystemClock.sleep(1000);
                    }
                }
            });
            th.setName("consumer-" + i);
            th.start();
        }
    }

    private void product() {
        synchronized (queue) {
            String data = Thread.currentThread().getName() + "生产";
            queue.offer(data);
            Log.d("TestSolution", data);
        }
    }

    private void consumer() {
        synchronized (queue) {
            String data = String.format("%1$s%2$s%3$s", Thread.currentThread().getName(), ", 消费: ", queue.poll());
            Log.d("TestSolution", data);
        }
    }

    @Override
    public String getResult() {
        producerAndConsumer();
        StringBuilder sb = new StringBuilder();
        sb.append(Math.sqrt(16));
        return sb.toString();
    }
}
