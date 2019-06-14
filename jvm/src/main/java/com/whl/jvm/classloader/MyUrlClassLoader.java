/**
 * FileName: MyUrlClassLoader
 * Author:   whl
 * Date:     2019/5/16 15:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.whl.jvm.classloader;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/5/16
 * @since 1.0.0
 */
public class MyUrlClassLoader extends ClassLoader {

    public String classLoaderName;
    public String path;
    public String fileExtension = ".class";

    public MyUrlClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public MyUrlClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] b = null;
        try {
            b = getClassDataFromUrl(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name, b, 0, b.length);
    }

    private byte[] getClassDataFromUrl(String name) throws IOException {

        String allPath = path + name.replace(".", "\\") + fileExtension;

        URL url = new URL(allPath);
        InputStream is = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len;

        while ((len = is.read(buffer)) != -1) {
            out.write(buffer,0,len);
        }

        return out.toByteArray();

    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyUrlClassLoader loader = new MyUrlClassLoader("MyUrlClassLoader");
        Class clazz = loader.loadClass("");
        clazz.newInstance();
    }


}

