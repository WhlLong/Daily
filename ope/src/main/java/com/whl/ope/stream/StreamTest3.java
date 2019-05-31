package com.whl.ope.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/5/30
 * @since 1.0.0
 */
public class StreamTest3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(list.stream().map(i -> 2 * i).reduce(0, Integer::sum));

        System.out.println(list.stream().map(i -> 2*i).reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Integer.sum(integer,integer2);
            }
        }));

    }

}