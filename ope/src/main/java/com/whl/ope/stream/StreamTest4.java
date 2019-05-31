package com.whl.ope.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/5/30
 * @since 1.0.0
 */
public class StreamTest4 {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("Hello","World","HelloWorld");

        String[] arr = stringStream.toArray(length -> new String[length]);
        Arrays.asList(arr).stream().forEach(System.out::println);

    }


}