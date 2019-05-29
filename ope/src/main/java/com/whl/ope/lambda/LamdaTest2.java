package com.whl.ope.lambda;


public class LamdaTest2 {

    public void myTest(MyFunctionalInterface myInterface) {
        System.out.println(1);
        myInterface.out();
        System.out.println(2);
    }

    public static void main(String[] args) {
        LamdaTest2 test2 = new LamdaTest2();

        test2.myTest(new MyFunctionalInterface() {
            @Override
            public void out() {
                System.out.println("my test");
            }
        });

        test2.myTest(() -> {
            System.out.println("mytest");
        });

        System.out.println("----------");

        MyFunctionalInterface myInterface = new MyFunctionalInterface() {
            @Override
            public void out() {
                System.out.println("hello...");
            }
        };


        MyFunctionalInterface myInterface2 = () -> {
            System.out.println("hello");
        };

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}
