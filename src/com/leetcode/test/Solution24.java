package com.leetcode.test;

import java.util.Stack;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        //利用栈
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = new ListNode(-1);
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        head = p;
        while (curr != null && curr.next != null) {
            stack.push(curr);
            stack.push(curr.next);
            curr = curr.next.next;
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        if (curr != null) {
            p.next = curr;
        }else{
            p.next = null;
        }
        return head.next;

        //递归
    }
    public static void main(String[] args) {

    }
}
