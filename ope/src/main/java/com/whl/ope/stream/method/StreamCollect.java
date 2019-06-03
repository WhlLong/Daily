package com.whl.ope.stream.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StreamCollect {

    public static void main(String[] args) {

        Stream<String> listStream = Stream.of("Hello", "World", "!");

//        List<String> asList = listStream.collect(() -> new ArrayList<>(), (list, item) -> {
//            list.add(item.toUpperCase());
//        }, ArrayList::addAll);

//        List<String> asList = listStream.collect(Collectors.toList());
//        asList.forEach(System.out::println);

//        String result = listStream.collect(Collectors.joining());    //HelloWorld!
//        String result = listStream.collect(Collectors.joining(",")); //Hello,World,!
//        String result = listStream.collect(Collectors.joining(",","1","2"));//1Hello,World,!2


//        System.out.println(result);
//

    }

}