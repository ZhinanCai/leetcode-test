package com.leetcode.test;

/**
 * 题目描述：leetcode 11
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int res = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
        while (i < j) {
            if(height[i]<height[j]){
                res = Math.max(res, (j - i) * height[i++]);
            }else{
                res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] h = {1,8,6,2,5,4,8,3,7};
        int[] h = {2,1};
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(h));
    }
}
