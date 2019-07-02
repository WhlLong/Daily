package com.whl.jvm.bytecode;

import java.util.Date;

/**
 * 〈〉
 * 针对方法调用的动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构(virtual method table,vtable)
 * 针对于invokeinterface指令来说，虚拟机会建立一个叫做接口方法表的数据结构(interface method table,itable),
 *
 * 虚方法表在类加载的连接阶段进行初始化，存放着各个方法的实际入口地址，
 * 如果某个方法在子类中没有被重写，那么子类的虚方法表中该方法的入口地址和父类保持一致。
 *
 *
 * @author whl
 * @create 2019/6/14
 * @since 1.0.0
 */
public class MyByteCode4 {

    public static void main(String[] args) {

        Animal animal = new Animal();
        Animal dog = new Dog();


        animal.test("Hello");
        dog.test(new Date());

    }

}


class Animal {
    public void test(String str) {
        System.out.println("Animal str");
    }

    public void test(Date date) {
        System.out.println("Animal date");
    }
}


class Dog extends Animal {
    @Override
    public void test(String str) {
        System.out.println("Dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("Dog date");
    }
}