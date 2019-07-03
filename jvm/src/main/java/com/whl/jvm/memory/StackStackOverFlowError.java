package com.whl.jvm.memory;


/**
 * 〈栈溢出〉
 *
 * @author whl
 * @create 2019/6/25
 * @since 1.0.0
 */
public class StackStackOverFlowError {

    public static void main(String[] args) {
        StackStackOverFlowError stackStackOverFlowError = new StackStackOverFlowError();
        stackStackOverFlowError.test();
    }


    private void test(){
        test();
    }

}