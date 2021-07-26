package com.leetcode.test;

public class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head=null;
        ListNode tail=null;
        while(l1!=null||l2!=null){
            int n1 = l1==null ? 0 : l1.val;
            int n2 = l2==null ? 0 : l2.val;
            int sum = (n1 +n2 + carry)%10;
            carry = (n1 +n2 + carry)/10;
            if(head==null){
                head = tail = new ListNode(sum);
            }else{
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;


        }
        if(carry!=0)tail.val = carry;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = Solution2.addTwoNumbers(l1, l2);
        System.out.println(res);
    }
}
