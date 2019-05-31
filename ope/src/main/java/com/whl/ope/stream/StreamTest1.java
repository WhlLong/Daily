package com.whl.ope.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/5/30
 * @since 1.0.0
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Stream stream1 =   Stream.of("Hello","World","HelloWorld");

        String[] data =  {"Hello","World","HelloWorld"};
        Stream stream2 = Stream.of(data);
        Stream stream3 = Arrays.stream(data);

        List<String> list = Arrays.asList("Hello","World","HelloWorld");
        Stream stream4 = list.stream();

    }

}