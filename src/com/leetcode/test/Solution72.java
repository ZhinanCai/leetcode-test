package com.leetcode.test;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        //
        // dp[i][j] = dp[][] + dp[][]
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for (int i = 1; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }
        for(int i = 0; i <= word1.length(); i++){
            for(int j = 0; j <= word2.length(); j++){
                if(char1[i]==char2[j]){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    int tmp = Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i - 1][j - 1], tmp)+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public static void main(String[] args) {


    }
}
