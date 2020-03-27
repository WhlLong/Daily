package com.whl.javase.sleep_volatile_println_integer;

import java.util.concurrent.TimeUnit;

/**
 * 由于变量 flag 没有被 volatile 修饰，而且在子线程休眠的 100ms 中，
 * while 循环的 flag 一直为 false，
 * 循环到一定次数后，触发了 jvm 的即时编译功能，
 * 进行循环表达式外提（Loop Expression Hoisting），导致形成死循环。
 * 而如果加了 volatile 去修饰 flag 变量，保证了 flag 的可见性，则不会进行提升。
 */
public class Demo1 {

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
        }
        System.out.println("程序结束,i=" + i);

    }
}
