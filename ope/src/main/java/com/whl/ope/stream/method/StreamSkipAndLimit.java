package com.whl.ope.stream.method;

import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StreamSkipAndLimit {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.skip(2).forEach(System.out::println);

        System.out.println("---------------");

        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5);
        integerStream2.limit(2).forEach(System.out::println);
    }

}