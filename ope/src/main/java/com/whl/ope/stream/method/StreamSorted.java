package com.whl.ope.stream.method;

import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StreamSorted {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 3, 2, 5, 4);
        integerStream.sorted((item1, item2) -> item1 - item2).forEach(System.out::println);

        System.out.println("----------------");

        Stream<Integer> integerStream2 = Stream.of(1, 3, 2, 5, 4);
        integerStream2.sorted((item1, item2) -> item2 - item1).forEach(System.out::println);

    }
}