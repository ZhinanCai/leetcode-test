package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str->{
            char[] c = str.toCharArray();
            Arrays.sort(c);
            return new String(c);
        })).values());
    }
}
