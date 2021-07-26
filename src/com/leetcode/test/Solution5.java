package com.leetcode.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：leetcode 3
 */
public class Solution5 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //首先将nums1设为短的那个
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        if(nums1.length==0){
            return (nums2.length&1)==1 ? nums2[nums2.length/2] :(double)(nums2[nums2.length/2-1]+nums2[nums2.length/2])/2;
        }
        int m = nums1.length;
        int n= nums2.length;
        int mid = m + (n - m + 1) / 2;   // 防止溢出  m + (n-m+1)/2
        int left = 0;
        int right = m;
        while (left < right) {
            int nums1Mid = right + (left - right + 1) / 2;     // +1防止陷入死循环
            int nums2Mid = mid - nums1Mid;
            if (nums1[nums1Mid - 1] > nums2[nums2Mid]) {
                right = nums1Mid - 1;
            }else {
                left = nums1Mid;                               // +1防止陷入死循环
            }
        }
        //二分查找
        //判断边界条件
        int i = left;
        int j = mid - i;
        int nums1LeftMax = i==0 ? Integer.MIN_VALUE: nums1[i-1];
        int nums1RightMin = i==m ? Integer.MAX_VALUE: nums1[i];
        int nums2LeftMax = j==0 ? Integer.MIN_VALUE: nums2[j-1];
        int nums2RightMin = j==n ? Integer.MAX_VALUE: nums2[j];
        //根据奇数偶数得到最终结果
        double res;
        if ((m + n) % 2 == 1) {
            res = Math.max(nums1LeftMax, nums2LeftMax);
        }else{
            res = (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))/2;
        }
        return res;


    }

    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {};
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.findMedianSortedArrays(nums1, nums2));
    }
}
