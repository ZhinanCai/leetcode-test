package com.leetcode.test;

import java.util.Stack;

public class Solution155 {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private int min;
    public Solution155() {
        stack = new Stack<Integer>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
            stack.push(0);
        }else{

            stack.push(val - min);
            min = min>val ? val : min;
        }
    }

    public void pop() {
        if(stack.peek()>=0){
            stack.pop();
        }else{
            min = min-stack.peek();
            stack.pop();
        }
        // min = stack.peek()>=0 ? min : min-stack.peek();
        // stack.pop();
    }

    public int top() {
        return stack.peek()>=0 ? min + stack.peek(): min;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
//        Solution155 s = new Solution155();
//        s.push(-2);
//        s.push(0);
//        s.push(-3);
//        s.pop();
//        System.out.println(s.getMin());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
