package com.whl.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 〈从尾到头逆序打印链表〉
 *
 * @author whl
 * @create 2019/7/18
 * @since 1.0.0
 */
public class InvertedSequencePrintLinkList {

    /**
     * 递归法
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        if (listNode != null) {
            list.addAll(printListFromTailToHead1(listNode.next));
            list.add(listNode.val);
        }

        return list;
    }


    /**
     * 头插法
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode mem = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = mem;
        }


        //构建ArrayList
        ArrayList<Integer> arrayList = new ArrayList();
        head = head.next;
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }

        return arrayList;
    }


    /**
     * 借用栈结构
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }


    public static void main(String[] args) {

    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}