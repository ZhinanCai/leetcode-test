package com.leetcode.test;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                flag = true;
                break;
            }

        }
        if (flag) {
            fast = head;
            while(true){
                if(slow==fast){
                    return fast;
                }
                slow = slow.next;
                fast = fast.next;
            }
        }else{
            return null;
        }
    }
    public static void main(String[] args) {

    }
}
