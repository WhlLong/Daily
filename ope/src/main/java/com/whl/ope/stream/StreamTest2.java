package com.whl.ope.stream;

import java.util.stream.IntStream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/5/30
 * @since 1.0.0
 */
public class StreamTest2 {

    public static void main(String[] args) {

        IntStream.of(new int[]{5,6,7}).forEach(System.out::println);
        System.out.println("------");

        //range包含前面的范围，不包含后面的范围
        IntStream.range(3,8).forEach(System.out::println);
        System.out.println("------");
        //rangeClose包含前面的范围，也包含后面的范围
        IntStream.rangeClosed(3,8).forEach(System.out::println);

    }

}