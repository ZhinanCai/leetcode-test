package com.leetcode.test;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,100,1,1,1,100,1,1,100,1};
//        int[] nums = new int[]{10,15,20};
        Solution746 s = new Solution746();
        System.out.println(s.minCostClimbingStairs(nums));

    }
}
