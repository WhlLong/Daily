package com.whl.jvm.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * 〈WeakHashMapDemo〉
 *
 * @author whl
 * @create 2019/6/27
 * @since 1.0.0
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();

        System.out.println("================");

        myWeakHashMap();
    }



    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String val = "HelloMap";

        map.put(key, val);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());

    }


    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String val = "HelloMap";

        map.put(key, val);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());


    }



    private static void myWeakHashMap2() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        String val = "HelloMap";

        map.put(new Integer(1), val);
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());

    }


}