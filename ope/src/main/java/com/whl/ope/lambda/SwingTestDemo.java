package com.whl.ope.lambda;

import javax.swing.*;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/5/27
 * @since 1.0.0
 */
public class SwingTestDemo {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("WHL  JFrame");
        JButton jButton = new JButton("WHL JButton");
/*        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("JButton clicked: "+e.getActionCommand());
            }
        });*/

        //通过类型推断 event一定是new ActionListener(){...}
        //(param1,param2,param3) -> {}  lamda表达式最基本的写法
        jButton.addActionListener((event) -> {
            System.out.println("JButton clicked: " + event.getActionCommand());
        });


        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}