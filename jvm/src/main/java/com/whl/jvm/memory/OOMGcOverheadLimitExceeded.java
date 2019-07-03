package com.whl.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈运行时常量池OOM GC overhead limit exceeded〉
 *
 * @author whl
 * @create 2019/6/25
 * @since 1.0.0
 */
public class OOMGcOverheadLimitExceeded {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {

            //修改虚拟机参数为-Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
            //Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
            //GC Overhead limit 用来防止 90%的时间回收2%不到的内存则会在OOM出现之前报错，避免出现OOM事件
            //-XX:-UseGCOverheadLimit，关闭这个特性
            list.add(String.valueOf(i++).intern());
            System.out.println(i++);
        }
    }

}