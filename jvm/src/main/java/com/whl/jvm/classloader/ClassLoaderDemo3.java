package com.whl.jvm.classloader;

/**
 * 〈jvm命名空间〉
 *
 * @author whl
 * @create 2019/5/23
 * @since 1.0.0
 */
public class ClassLoaderDemo3 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyFilePathClassLoader myClassLoader = new MyFilePathClassLoader("loader1");
        myClassLoader.setPath("C:\\Users\\pc-20171125\\Desktop\\");
        Class clazz = myClassLoader.loadClass("com.whl.jvm.classloader.MyPerson");
        clazz.newInstance();
        System.out.println(clazz.getClassLoader());


        MyFilePathClassLoader myClassLoader2 = new MyFilePathClassLoader("loader2");
        myClassLoader2.setPath("C:\\Users\\pc-20171125\\Desktop\\");
        Class clazz2 = myClassLoader2.loadClass("com.whl.jvm.classloader.MyPerson");
        clazz2.newInstance();
        System.out.println(clazz2.getClassLoader());


    }


}