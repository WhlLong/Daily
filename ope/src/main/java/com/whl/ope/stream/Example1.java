package com.whl.ope.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 〈
 * 给定一个集合 1,3,5,7,9,11
 * 找出流中大于2的元素，然后将每个元素乘以2，然后忽略掉流中的前两个元素，然后再取流中的前两个元素，然后求中六种元素的总和
 * <p>
 * 〉
 *
 * @author whl
 * @create 2019/5/31
 * @since 1.0.0
 */
public class Example1 {

    public static void main(String[] args) {

        List<Integer> data = Arrays.asList(1, 3, 5, 7, 9, 11);
        int result = data.stream().filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).min().orElseGet(() -> 666);
        System.out.println(result);

        data.stream().filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).max().ifPresent(System.out::println);

    }

}