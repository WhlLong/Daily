package com.whl.jvm.classloader;

import sun.reflect.Reflection;


/**
 * 〈获取类加载器的相关方法〉
 *
 * @author whl
 * @create 2019/5/21
 * @since 1.0.0
 */
public class ClassLoaderDemo1 {

    public static void main(String[] args) {

        Class clazz = ClassLoaderDemo1.class;

        //获得当前类的ClassLoader
        ClassLoader loader1 = clazz.getClassLoader();
        System.out.println(loader1);

        //获取当前线程上下文的ClassLoader
        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader2);

        //获取系统的ClassLoader
        ClassLoader loader3 =  ClassLoader.getSystemClassLoader();
        System.out.println(loader3);

    }

}