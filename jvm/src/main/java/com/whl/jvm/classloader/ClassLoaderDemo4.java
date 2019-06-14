package com.whl.jvm.classloader;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈com.whl.jvm.classloader.MyPerson Can not Cast to com.whl.jvm.classloader.MyPerson问题〉
 *
 * @author whl
 * @create 2019/5/23
 * @since 1.0.0
 */
public class ClassLoaderDemo4 {

    public static void main(String[] args) throws Exception {
        MyFilePathClassLoader myClassLoader1 = new MyFilePathClassLoader("loader1");
        myClassLoader1.setPath("C:\\Users\\pc-20171125\\Desktop\\");
        Class clazz1 = myClassLoader1.loadClass("com.whl.jvm.classloader.MyPerson");

        MyFilePathClassLoader myClassLoader2 = new MyFilePathClassLoader("loader2");
        myClassLoader2.setPath("C:\\Users\\pc-20171125\\Desktop\\");
        Class clazz2 = myClassLoader2.loadClass("com.whl.jvm.classloader.MyPerson");

        Method method = clazz1.getMethod("setMyPerson",Object.class);
        method.invoke(clazz1.newInstance(),clazz2.newInstance());

    }





}