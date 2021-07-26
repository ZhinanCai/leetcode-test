package com.com.exam.test;

import java.util.Arrays;

public class Test11 {
    public static void moveZeroes(int[] nums) {
//        for(int i = 0;i<nums.length;i++){
//
//        }
//        int k = 0;
//        while(nums[k++]!=0);
//        System.out.println(k);
//         j = k;
//        while(nums[j++]==0);
//        System.out.println(j);
//        int tmp = nums[j-1];
//        nums[j-1] = nums[k-1];
//        nums[k - 1] = tmp;


        int len = nums.length;
        int i = 0;
        int j = i+1;
        while(i<len && j<len){
            while(nums[i++]!=0);
            j = i;
            while(nums[j++]==0);
            --i;//第一个零 位置
            --j;//第一个零后的第一个非零位置
            swap(nums, i, j);
            i++;
            j++;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 5, 0, 3};
        nums = new int[] {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
