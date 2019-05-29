package com.whl.ope.methodref;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class MethodReferenceTest {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

//        students.sort((studentParam1, studentParam2) ->
//                Student.compareStudentByScore(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getScore()));

//        System.out.println("-------");

//        students.sort(Student::compareStudentByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort((studentParam1, studentParam2) ->
//                Student.compareStudentByName(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getName()));

//        students.sort(Student::compareStudentByName);
//        students.forEach(student -> System.out.println(student.getName()));

        StudentComparator studentComparator = new StudentComparator();

//        students.sort((studentParam1, studentParam2) ->
//                studentComparator.compareStudentByScore(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort(studentComparator::compareStudentByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort((studentParam1, studentParam2) ->
//                studentComparator.compareStudentByName(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getName()));

//        students.sort(studentComparator::compareStudentByName);
//        students.forEach(student -> System.out.println(student.getName()));

        //调用sort方法的实例对象，会作为Comparator接口的第一个参数，所以才能使用类名和实例方法来实现方法引用
//        students.sort(Student::compareByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort(Student::compareByName);
//        students.forEach(student -> System.out.println(student.getName()));


//        List<String> cities = Arrays.asList("qingdao", "chongqing", "tianjin", "beijing");
//
//        Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
//        cities.forEach(city -> System.out.println(city));
//
//        Collections.sort(cities, String::compareToIgnoreCase);
//        cities.forEach(System.out::println);

//        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
//        System.out.println(methodReferenceTest.getString(String::new));
//        System.out.println(methodReferenceTest.getString2("hello", String::new));


        /**
         * @method:
         * @description: 所有的对象都会有一个wait_set .用来存放该对象wait方法之后的线程
         * 线程被notify之后,不一定立即执行
         */
        IntStream.rangeClosed(1, 10).forEach(i ->
                new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            try {
                                Optional.of(Thread.currentThread().getName() + " will come to wait set").ifPresent(System.out::println);
                                LOCK.wait();
                                Optional.of(Thread.currentThread().getName() + " will leave to wait set").ifPresent(System.out::println);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );

        IntStream.rangeClosed(1, 10).forEach(i -> {
                    synchronized (LOCK) {
                        System.out.println("-----");
                        LOCK.notify();
                       /*try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    }
                }

        );
    }
}
