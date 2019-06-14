package com.whl.jvm.classloader;

public class MyPerson {

    static {
        System.out.println("MyPerson Class init");
    }

    private MyPerson myPerson;

    public void setMyPerson(Object object) {
        myPerson = (MyPerson)object;
    }

}
