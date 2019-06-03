package com.whl.ope.stream.method;

import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StreamFilter {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 3, 3,5);
        integerStream.filter(item -> item > 2).distinct().forEach(System.out::println);

    }

}