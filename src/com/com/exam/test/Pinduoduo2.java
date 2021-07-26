package com.com.exam.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Pinduoduo2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums1 = new int[n];
//        int[] nums2 = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums1[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            nums2[i] = sc.nextInt();
//        }
        int n = 4;
        int[] nums1 = new int[]{1, 3, 5, 1};
        int[] nums2 = new int[]{2, 5, 7, 8};
        Stack<Integer> stack = new Stack();
        int res1 = 0;
        int res2 = 0;
        int i = 0;
        int j = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        while (i < n || j < n) {
            if(i<n&& stack.search(nums1[i]) == -1){
                stack.push(nums1[i]);
                i++;
            }else{
                while (i < n) {
                    while (i < n && stack.search(nums1[i]) != -1) {
                        res1++;
                        stack.pop();
                        flag1 = true;
                    }
                    if (flag1) {
                        res1++;
                        i++;
                        flag1 = false;
                    }
                    if(i < n && stack.search(nums1[i]) != -1){
                        continue;
                    }else if(i < n && stack.search(nums1[i]) == -1){
                        stack.push(nums1[i]);
                        i++;
                        break;
                    }
                }

            }

            if (j < n &&stack.search(nums2[j]) == -1) {
                stack.push(nums2[j]);
                j++;
            }else{
                while (j < n) {
                    while (j < n && stack.search(nums2[j]) != -1) {
                        res2++;
                        stack.pop();
                        flag2 = true;
                    }
                    if (flag2) {
                        res2++;
                        j++;
                        flag2 = false;
                    }
                    if (j < n &&stack.search(nums2[j]) != -1) {
                        continue;
                    }else if(j < n &&stack.search(nums2[j]) == -1){
                        stack.push(nums2[j]);
                        j++;
                        break;
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            if ((stack.peek() & 1) == 0) {
                res2++;
                stack.pop();
            }else{
                res1++;
                stack.pop();
            }
        }
        System.out.println(res1+" "+res2);
    }
}
