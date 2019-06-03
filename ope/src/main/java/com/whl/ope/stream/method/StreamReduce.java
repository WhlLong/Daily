package com.whl.ope.stream.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StreamReduce {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 3, 5);
        Optional<Integer> result = integerStream.reduce((v1, v2) -> {
            return v1 + v2;
        });
        result.ifPresent(item -> {
            System.out.println(item);
        });

        System.out.println("------");

        Stream<Integer> integerStream2 = Stream.of(1, 3, 5);
        Integer result2 = integerStream2.reduce(666, (v1, v2) -> {
            return v1 + v2;
        });

        System.out.println(result2);


        System.out.println("------");

        Stream<Integer> integerStream3 = Stream.of(1, 3, 5);
        List<Integer> result3 = integerStream3.reduce(new ArrayList<>(Arrays.asList(66, 88))
                , (List<Integer> integers, Integer integer) -> {
                    integers.add(integer);
                    return integers;
                }
                , (List<Integer> integers, List<Integer> integers2) -> {
                    integers2.addAll(integers);
                    return integers2;
                }
        );

        result3.forEach(item -> System.out.println(item));

    }

}