package com.whl.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/3/19
 * @since 1.0.0
 */
public class SubmitDemo {

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public  void exec() throws ExecutionException, InterruptedException {

        SubmitDemo executeDemo = new SubmitDemo();

        for (int i = 0; i < 100; i++) {
//            Future<String> future = executeDemo.executorService.submit(new CallableWorker(i));
            Future<String> future = executeDemo.executorService.submit(new Worker(i),"Hello World");
            System.out.println(future.get());
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


    class CallableWorker implements Callable<String> {

        int index;

        public CallableWorker(int index) {
            this.index = index;
        }

        @Override
        public String call() {
            System.out.println("index:" + index + " ThreadName:" + Thread.currentThread().getName());

            return index+"";
        }
    }

}