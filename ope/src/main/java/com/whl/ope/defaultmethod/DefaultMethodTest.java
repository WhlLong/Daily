package com.whl.ope.defaultmethod;

//public class MyClass   implements MyInterface1,MyInterface2{
//Error:(5, 8) java: 类 com.whl.ope.defaultmethod.MyClass从类型 com.whl.ope.defaultmethod.MyInterface1 和 com.whl.ope.defaultmethod.MyInterface2 中继承了myMethod() 的不相关默认值

//public class MyClass   implements MyInterface2{

public class DefaultMethodTest extends MyInterface1Impl implements MyInterface1,MyInterface2{

    public static void main(String[] args) {
        DefaultMethodTest myClass = new DefaultMethodTest();

        //如果继承了MyInterface1Impl，那么这里的myMethod调用的是MyInterface1Impl中的myMethod方法
        myClass.myMethod();
    }
}
