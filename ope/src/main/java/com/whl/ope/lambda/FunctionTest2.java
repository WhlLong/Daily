package com.whl.ope.lambda;


import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test = new FunctionTest2();

        /**
         * Function接口的compose方法和andThen方法的区别是:
         * compose方法返回的组合函数，其内部原理是先执行参数的apply方法，再执行当前Function实例的apply方法
         * anThen方法返回的组合函数，其内部原理是先执行当前Function实例的apply方法，再执行输入参数的apply方法
         *
         */
        System.out.println(test.compute(2, value -> value * 3, value -> value * value)); // 12
        System.out.println(test.compute2(2, value -> value * 3, value -> value * value)); // 36

        System.out.println(test.compute3(1, 2, (value1, value2) -> value1 + value2));
        System.out.println(test.compute3(1, 2, (value1, value2) -> value1 - value2));
        System.out.println(test.compute3(1, 2, (value1, value2) -> value1 * value2));
        System.out.println(test.compute3(1, 2, (value1, value2) -> value1 / value2));

        System.out.println(test.compute4(2, 3, (value1, value2) -> value1 + value2, value -> value * value)); //25



    }


    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,
                        Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
























