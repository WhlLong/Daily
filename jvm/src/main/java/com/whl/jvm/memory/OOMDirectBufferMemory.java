package com.whl.jvm.memory;

import java.nio.ByteBuffer;

/**
 * 〈直接内存溢出〉
 * -Xmx20M
 * -XX:MaxDirectMemorySize=5M 设置DirectMemory容量，如果没有指定，则默认与java堆最大值一样
 *
 * @author whl
 * @create 2019/6/25
 * @since 1.0.0
 */
public class OOMDirectBufferMemory {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        System.out.println("maxDirectMemory: " + sun.misc.VM.maxDirectMemory() / (1024 * 1024) + "MB");

        //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * _1MB);

    }

}