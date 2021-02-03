package com.springchang.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * @author : 张翠山
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }

        for (int i = 0; i < k-1; i++) {
            stack.pop();
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        KthToLast demo = new KthToLast();
        int value = demo.kthToLast(listNode1, 2);
        System.out.println("value = " + value);
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}