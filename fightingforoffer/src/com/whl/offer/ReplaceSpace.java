package com.whl.offer;

/**
 * 〈替换空格〉
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author whl
 * @create 2019/7/18
 * @since 1.0.0
 */
public class ReplaceSpace {


    public String replaceSpace(StringBuffer str) {

        if(str == null){
            return "";
        }

        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;

        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }

        return str.toString();
    }


    public static void main(String[] args) {

        ReplaceSpace replaceSpace = new ReplaceSpace();
        String result = replaceSpace.replaceSpace(new StringBuffer(" A B "));
        System.out.println(result);
    }

}