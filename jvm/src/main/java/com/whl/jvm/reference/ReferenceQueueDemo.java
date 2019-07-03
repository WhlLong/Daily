package com.whl.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱引用和虚引用在被回收之前会被放入ReferenceQueue
 *
 * @author whl
 * @create 2019/6/27
 * @since 1.0.0
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());


        System.out.println("===========");

        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }

}