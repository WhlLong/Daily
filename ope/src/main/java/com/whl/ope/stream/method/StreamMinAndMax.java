package com.whl.ope.stream.method;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StreamMinAndMax {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> result =  integerStream.min((item, item2) -> item - item2);
        result.ifPresent(System.out::println);

        System.out.println("------------");

        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> result2 =  integerStream2.max((item, item2) -> item - item2);
        result2.ifPresent(System.out::println);
    }

}