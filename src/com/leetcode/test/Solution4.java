package com.leetcode.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：leetcode 3
 */
public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if(map.containsKey(s.charAt(end))){
                //加1表示从当前字符的下一个开始才不重复
                start = Math.max(start, map.get(s.charAt(end))+1);
            }
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return res;
    }



    public static void main(String[] args) {
        String s = "pwwkew";
        Solution4 solution3 = new Solution4();
        System.out.println(solution3.lengthOfLongestSubstring(s));
    }
}
