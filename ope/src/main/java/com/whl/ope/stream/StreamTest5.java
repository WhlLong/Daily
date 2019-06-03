package com.whl.ope.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈给定一个字符串集合，将集合中的字符都改成大写然后输出出来〉
 *
 * @author whl
 * @create 2019/5/31
 * @since 1.0.0
 */
public class StreamTest5 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Hello","World","!");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("-------------");

        List<Integer> list2 = Arrays.asList(1,3,5,7,9);
        list2.stream().map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("-------------");

        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1,3),Arrays.asList(2,4),Arrays.asList(5,6));
        //list -> list -> list      =>     流 -> 流 -> 流
        listStream.flatMap(item -> item.stream()).map(item -> item*item).forEach(System.out::println);

    }


}