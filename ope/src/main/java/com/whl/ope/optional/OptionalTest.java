package com.whl.ope.optional;


import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("hello");

//        if(optional.isPresent()) {
//            System.out.println(optional.get());
//        }

        optional.ifPresent(item -> System.out.println(item)); //推荐的Optional使用方式
        System.out.println("-------");

        System.out.println(optional.orElse("world"));
        System.out.println("---------");

        System.out.println(optional.orElseGet(() -> "nihao"));


        System.out.println("---分隔线--");


        Optional<String> optionalNull = Optional.ofNullable(null);

        optionalNull.ifPresent(item -> System.out.println(item)); //推荐的Optional使用方式
        System.out.println("-------");

        System.out.println(optionalNull.orElse("world"));
        System.out.println("---------");

        System.out.println(optionalNull.orElseGet(() -> "nihao"));

    }
}
