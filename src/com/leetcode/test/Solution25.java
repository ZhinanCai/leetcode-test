package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }
        ListNode hair = new ListNode(-1);
        ListNode pre = hair;
        hair.next = head;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            //进行翻转
            ListNode[] ln = reverse(head, tail);
            head = ln[0];
            tail = ln[1];
            //加入原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = next;
        }
        return hair.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;

        while (pre != tail) {   //易错
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
    public static void main(String[] args) {

    }
}
