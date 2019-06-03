package com.whl.ope.stream.method;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StreamMap {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 3, 5);
        List<Integer> list = integerStream.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        }).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("----------");

        Stream<Integer> integerStream2 = Stream.of(2, 4, 6);
        List<Integer> list2 = integerStream2.map(item -> item / 2).collect(Collectors.toList());
        list2.forEach(System.out::println);

    }

}