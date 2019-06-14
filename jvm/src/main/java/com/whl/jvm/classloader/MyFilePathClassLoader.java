/**
 * FileName: MyClassLoader
 * Author:   whl
 * Date:     2019/5/15 15:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.whl.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/5/15
 * @since 1.0.0
 */
public class MyFilePathClassLoader extends ClassLoader {

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public void setPath(String path){
        this.path = path;
    }

    public MyFilePathClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyFilePathClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] arr = null;
        try {
            arr = getClassByteData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name,arr,0,arr.length);
    }

    private byte[] getClassByteData(String name) throws IOException {

        File file = new File(path+name.replace(".","\\")+fileExtension);
        FileInputStream fis = new FileInputStream(file);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int arr;

        while ((arr = fis.read()) != -1){
            out.write(arr);
        }


        return out.toByteArray();
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyFilePathClassLoader myClassLoader = new MyFilePathClassLoader("WhlClassLoader");
        myClassLoader.setPath("C:\\Users\\pc-20171125\\Desktop\\");
        /**
         * 加载java.lang包需要权限:
         * Exception in thread "main" java.lang.SecurityException: Prohibited package name: java.lang
         */
//        myClassLoader.loadClass("java.lang.MyInteger");
        Class clazz = myClassLoader.loadClass("com.whl.jvm.classloader.MyPerson");
        clazz.newInstance();


        MyFilePathClassLoader myClassLoader2 = new MyFilePathClassLoader("WhlClassLoader");
        myClassLoader2.setPath("C:\\Users\\pc-20171125\\Desktop\\");
        /**
         * 加载java.lang包需要权限:
         * Exception in thread "main" java.lang.SecurityException: Prohibited package name: java.lang
         */
//        myClassLoader.loadClass("java.lang.MyInteger");
        Class clazz2 = myClassLoader2.loadClass("com.whl.jvm.classloader.MyPerson");
        clazz2.newInstance();

    }
}