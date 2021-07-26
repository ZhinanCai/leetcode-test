package com.leetcode.test;

import java.util.HashSet;
import java.util.List;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
//        //hash
//        HashSet<ListNode> set = new HashSet<>();
//        while (head != null || head.next != null) {
//            if(!set.add(head)){
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
        //double pointer
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if(slow==fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;

    }
    public static void main(String[] args) {

    }
}
