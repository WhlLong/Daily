package com.whl.jvm.memory;

/**
 * 〈〉
 *
 * 该native thread异常与平台有关系
 *
 * 导致原因:
 * 1.应用创建了太多线程了，一个应用进程创建多个线程，超过系统承载极限
 * 2.服务器不允许应用程序创建这么多的线程，linux系统默认允许单个线程可以创建的线程数是1024个，
 * 超过这个数量，就会报java.lang.OutOfMemoryError: unable to create new native thread.
 *
 * 解决办法:
 * 1.降低应用创建线程的数量，分析应用是否真的需要创建那么多的线程，如果不是，改代码降低线程数。
 * 2.对于有的应用，确实需要那么多的线程，远超过linux默认的1024个，可以通过修改linux服务器配置，扩大linux的默认限制。
 *
 * @author whl
 * @create 2019/6/27
 * @since 1.0.0
 */
public class OOMUnableToCreateNewNativeThread {

    public static void main(String[] args) {

        for(int i=1;;i++){
            System.out.println("************ i = "+i);
            //java.lang.OutOfMemoryError: unable to create new native thread.
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },""+i).start();
        }


    }

}