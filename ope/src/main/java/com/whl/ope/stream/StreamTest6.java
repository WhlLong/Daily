package com.whl.ope.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * 〈Stream方法之generate、iterate和limit
 *
 *  generate : 根据输入的值生成一个流
 *  iterate : 重复行为，可用于对某个变量做多次重复操作
 *  limit： 限制产生多少条数据
 *
 * 〉
 *
 * @author whl
 * @create 2019/5/31
 * @since 1.0.0
 */
public class StreamTest6 {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.generate(UUID.randomUUID()::toString);
//        System.out.println(stringStream.findFirst().get());
//        stringStream.findFirst().ifPresent(System.out::println);


//        Stream.iterate(stringStream.findFirst().get(), item -> item.toString()+"-").limit(6).forEach(System.out::println);


        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6); //1、3、5、7、9、11
//        stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).max().ifPresent(System.out::println);


        IntSummaryStatistics summaryStatistics = stream.filter(item -> item > 2).
                mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();

        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMax());

//        System.out.println(stream);
//        System.out.println(stream.filter(item -> item > 2));
//        System.out.println(stream.distinct());


//        System.out.println(stream);
//        Stream<Integer> stream2 = stream.filter(item -> item > 2);
//        System.out.println(stream2);
//        Stream<Integer> stream3 = stream2.distinct();
//        System.out.println(stream3);

    }

}