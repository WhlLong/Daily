package com.whl.jvm.bytecode;

/**
 * 〈方法的静态分派〉
 * <p>
 * GrandPa g1 = new Father();
 * 以上代码，g1的静态类型时GrandPa,而g1的实际类型(真正指向的类型)是Father.
 * <p>
 * 通过运行结果可以得出这样一个结论: 变量的静态类型是不会发生变化的，
 * 而变量的实际类型时可以发生变化的(这是多态的一种体现)，
 * 实际类型是在运行期才能确定的。
 * <p>
 * 方法重载是一种静态行为，这种静态行为在编译期就可以完全确定。
 *
 *  与方法重载不同，方法重写是一种动态的行为，运行期才能确定。
 * 《方法的动态分派》
 *  方法的动态分派涉及到一个重要概念： 方法接收者
 *  invokevirtual字节码指令的多态查找流程
 *  1.到操作数栈栈顶寻找到栈顶元素指向的对象的实际类型
 *  2.如果在此实际类型中找到了与常量池中描述符和名称都相同的方法，并且访问权限也符合
 *  直接返回该方法的调用
 *  3.如果步骤二没有查找到，那么就按照继承的顺序从下往上，到父类中查找，如果一直都查不到，就抛出异常了。
 *
 * @author whl
 * @create 2019/6/14
 * @since 1.0.0
 */
public class MyByteCode3 {

    //在进行参数类型匹配时，判断的是传入参数的静态类型，而不是其实际类型。
    public void test(GrandPa grandPa) {
        System.out.println("grandPa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }


    public static void main(String[] args) {
        GrandPa g1 = new Father();
        GrandPa g2 = new Son();

        MyByteCode3 myByteCode3 = new MyByteCode3();
        myByteCode3.test(g1);   //grandPa
        myByteCode3.test(g2);   //grandPa

        g1.out();
        g2.out();
    }

}


class GrandPa {
    public void out() {
        System.out.println("GrandPa Out");
    }
}

class Father extends GrandPa {

    @Override
    public void out() {
        System.out.println("Father Out");
    }
}

class Son extends Father {
    @Override
    public void out() {
        System.out.println("Son Out");
    }
}