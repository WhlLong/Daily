package com.whl.ope.defaultmethod;


public interface MyInterface1 {

    default void myMethod() {
        System.out.println("MyInterface1");
    }
}
