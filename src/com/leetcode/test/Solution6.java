package com.leetcode.test;

/**
 * 题目描述：leetcode 3
 */
public class Solution6 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2){
            return s;
        }
        boolean[][] dp = new boolean[len][len];

        for(int i = 0;i<len;i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int position = 0;
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if(charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&maxLen<(j-i+1)){
                    maxLen = j - i + 1;
                    position = i;
                }
            }
        }
        return s.substring(position, position + maxLen);
    }

    public static void main(String[] args) {
        String s = "ac";
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.longestPalindrome(s));
    }
}
