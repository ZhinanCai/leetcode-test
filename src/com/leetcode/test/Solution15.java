package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述：leetcode 15
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //先排序后使用双指针
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;//需要注意++i表示先加后计算是否相等  i++表示先计算是否相等然后加1
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution15 solution15 = new Solution15();
        List<List<Integer>> ls = solution15.threeSum(nums);
        System.out.println(solution15.threeSum(nums));

    }
}
