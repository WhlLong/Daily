package com.whl.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/5/21
 * @since 1.0.0
 */
public class ClassLoaderDemo2 {

    public static void main(String[] args) {

        Class clazz1 = Long.class;
        System.out.println(clazz1.getClassLoader());

        Class clazz2 = AESKeyGenerator.class;
        System.out.println(clazz2.getClassLoader());

        Class clazz3 = ClassLoaderDemo1.class;
        System.out.println(clazz3.getClassLoader());
    }

}