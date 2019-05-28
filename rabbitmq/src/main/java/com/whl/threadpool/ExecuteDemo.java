package com.whl.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/3/19
 * @since 1.0.0
 */
public class ExecuteDemo {

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public  void exec() {

        ExecuteDemo executeDemo = new ExecuteDemo();

        for (int i = 0; i < 100; i++) {
            executeDemo.executorService.execute(new Worker(i));
        }

        executeDemo.executorService.shutdown();
    }

    class Worker implements Runnable {

        int index;

        public Worker(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("index:" + index + " ThreadName:" + Thread.currentThread().getName());
        }
    }



}