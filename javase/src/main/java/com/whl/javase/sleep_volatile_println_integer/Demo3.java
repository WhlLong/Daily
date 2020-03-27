package com.whl.javase.sleep_volatile_println_integer;

import java.util.concurrent.TimeUnit;

/**
 * 1.Thread.sleep 没有任何同步语义（Thread.yield也是）。
 * 编译器不必在调用 Thread.sleep 之前将缓存在寄存器中的写刷新到共享内存，
 * 也不必在调用 Thread.sleep 之后重新加载缓存在寄存器中的值。
 *
 * 2.编译器可以**自由（free）**读取 done 这个字段仅一次。
 * 自由，意味着编译器可以选择只读取一次，也可以选择每次都去读取，这才是自由的含义。这是编译器自己的选择
 *
 */
public class Demo3 {

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
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束,i=" + i);

    }
}
