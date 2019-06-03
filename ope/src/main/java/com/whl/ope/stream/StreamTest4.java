package com.whl.ope.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈Stream之collect方法〉
 *
 * @author whl
 * @create 2019/5/30
 * @since 1.0.0
 */
public class StreamTest4 {

    public static void main(String[] args) {

//        Stream<String> stringStream = Stream.of("Hello","World","HelloWorld");
//
//        String[] arr = stringStream.toArray(length -> new String[length]);
//        Arrays.asList(arr).stream().forEach(System.out::println);

        Stream<String> stringStream2 = Stream.of("Hello2", "World2", "HelloWorld2");
//      List<String> list = stringStream2.collect(Collectors.toList());
        List<String> list = stringStream2.collect(new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return new ArrayList<>();
            }
        }, new BiConsumer<List<String>, String>() {
            @Override
            public void accept(List<String> strings, String s) {
                strings.add(s);
            }
        }, (list1, list2) -> {
        });

//        List<String> list = stringStream2.collect(() -> new ArrayList<>(),(list1,item) -> list1.add(item),(list1,list2)->list2.addAll(list1));

//        List<String> list = stringStream2.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);

//        list.stream().forEach(System.out::println);

        Stream<String> stringStream3 = Stream.of("Hello3", "World3", "HelloWorld3");
//        List<String> list3 = stringStream3.collect(Collectors.toCollection(ArrayList::new));\
//        list3.forEach(System.out::println);
        Set<String> set3 = stringStream3.collect(Collectors.toCollection(TreeSet::new));
        set3.forEach(System.out::println);


        Stream<String> stringStream4 = Stream.of("Hello4", "World4", "HelloWorld4");
        String result = stringStream4.collect(Collectors.joining()).toString();
        System.out.println(result);
    }


}