package com.whl.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈堆内存溢出〉
 *  -Xms20m -Xmx20m  -XX:+HeapDumpOnOutOfMemoryError
 * @author whl
 * @create 2019/6/25
 * @since 1.0.0
 */
public class OOMJavaHeapSpace {


    public static void main(String[] args) {
        List<OOMJavaHeapSpace> list = new ArrayList<>();

        while(true){
            //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            list.add(new OOMJavaHeapSpace());
        }

    }


}