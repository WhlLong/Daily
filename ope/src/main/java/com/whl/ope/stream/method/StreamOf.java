package com.whl.ope.stream.method;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StreamOf {

    public static void main(String[] args) {

        String obj = "Hello World";
        Stream<String> singleStream = Stream.of(obj);

        Stream<String> listStream = Stream.of("Hello", "World", "!");

    }

}