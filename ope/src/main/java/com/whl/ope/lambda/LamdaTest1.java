package com.whl.ope.lambda;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LamdaTest1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }

        System.out.println("----------");

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println("----------");

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        });


        System.out.println("----------");

        list.forEach(c -> {
            System.out.println("c: " + c);
        });

        System.out.println("----------");

        /**
         *  PrintStream var10001 = System.out;
         *  System.out.getClass();
         *  list.forEach(var10001::println);
         */
        list.forEach(System.out::println);

    }


}
