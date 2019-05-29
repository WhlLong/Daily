package com.whl.ope.lambda;


import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> {return "hello world";};
        System.out.println(supplier.get());
    }
}
