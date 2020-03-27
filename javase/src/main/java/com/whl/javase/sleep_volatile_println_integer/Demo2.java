package com.whl.javase.sleep_volatile_println_integer;

import java.util.concurrent.TimeUnit;

/**
 * 1.StackOverFlow
 * 如果使用 System.out.println， JVM 将无法在循环期间缓存变量。
 *
 * 2.Doug Lea
 * 线程释放锁的操作，会强制性的将工作内存中涉及的，在释放锁之前的，所有写操作都刷新到主内存中去。
 * 而获取锁的操作，则会强制新的重新加载可访问的值到该线程的工作内存中去。
 *
 * 3.IO
 * 即使一个变量没有加 volatile 关键字，JVM 会尽力保证内存的可见性。
 * 但是如果 CPU 一直处于繁忙状态，JVM 不能强制要求它去刷新内存，所以 CPU 有没办法去保证内存的可见性了。
 * 而加了 System.out.println 之后，由于 synchronized  的存在，
 * 导致 CPU 并不是那么的繁忙（相对于之前的死循环而言）。
 * 这时候 CPU 就可能有时间去保证内存的可见性，于是 while 循环可以被终止。
 *
 */
public class Demo2 {

    private static boolean flag = false;
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                flag = true;
                System.out.println("flag 被修改成 true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        while (!flag) {
            i++;
            System.out.println("i="+i);
        }
        System.out.println("程序结束,i=" + i);

    }
}
