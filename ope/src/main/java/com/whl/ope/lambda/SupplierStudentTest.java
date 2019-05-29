package com.whl.ope.lambda;


import java.util.function.Supplier;

public class SupplierStudentTest {

    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());

        System.out.println("-------");

        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());
    }
}
